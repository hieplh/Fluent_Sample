package com.fluentcommerce.sample;

import com.config.CentralConfig;
import com.fluentcommerce.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.fulfilment.Fulfilment;
import com.fluentcommerce.model.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(config = CentralConfig.class)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    FulfilmentMapper fulfilmentMapper = FulfilmentMapper.INSTANCE;

    @Mapping(target = "id", expression = "java(source.id())")
    @Mapping(target = "ref", expression = "java(source.ref())")
    @Mapping(target = "type", expression = "java(source.type())")
    @Mapping(target = "status", expression = "java(source.status())")
    @Mapping(target = "attributes", expression = "java(mapAttributes(source))")
    @Mapping(target = "fulfilments", expression = "java(mapFulfilments(source.fulfilments()))")
    Order toOrderModel(GetOrderByIdQuery.OrderById source);

    default Map<String, Object> mapAttributes(GetOrderByIdQuery.OrderById source) {
        if (source == null || source.orderAttributes().isEmpty()) {
            return new HashMap<>();
        }
        return source.orderAttributes().stream()
                .collect(Collectors.toMap(GetOrderByIdQuery.OrderAttribute::name,
                        GetOrderByIdQuery.OrderAttribute::value));
    }

    default List<Fulfilment> mapFulfilments(GetOrderByIdQuery.Fulfilments source) {
        List<Fulfilment> fulfilmentEntities = new ArrayList<>();
        if (source != null && source.fulfilmentEdges() != null && !source.fulfilmentEdges().isEmpty()) {
            for (GetOrderByIdQuery.FulfilmentEdge fulfilmentEdge : source.fulfilmentEdges()) {
                fulfilmentEntities.add(fulfilmentMapper.toFulfilmentModel(fulfilmentEdge.fulfilmentNode()));
            }
        }
        return fulfilmentEntities;
    }
}
