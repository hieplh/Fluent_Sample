package com.fluentcommerce.sample;

import com.config.CentralConfig;
import com.fluentcommerce.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.fulfilment.Fulfilment;
import com.fluentcommerce.model.fulfilment.FulfilmentItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(config = CentralConfig.class)
public interface FulfilmentMapper {

    FulfilmentMapper INSTANCE = Mappers.getMapper(FulfilmentMapper.class);
    FulfilmentItemMapper fulfilmentItemMapper = FulfilmentItemMapper.INSTANCE;

    @Mapping(target = "id", expression = "java(source.id())")
    @Mapping(target = "ref", expression = "java(source.ref())")
    @Mapping(target = "type", expression = "java(source.type())")
    @Mapping(target = "status", expression = "java(source.status())")
    @Mapping(target = "attributes", expression = "java(mapAttributes(source))")
    @Mapping(target = "items", expression = "java(mapFulfilmentItem(source))")
    Fulfilment toFulfilmentModel(GetOrderByIdQuery.FulfilmentNode source);

    default Map<String, Object> mapAttributes(GetOrderByIdQuery.FulfilmentNode source) {
        if (source == null || source.fulfilmentAttributes().isEmpty()) {
            return new HashMap<>();
        }
        return source.fulfilmentAttributes().stream()
                .collect(Collectors.toMap(GetOrderByIdQuery.FulfilmentAttribute::name, GetOrderByIdQuery.FulfilmentAttribute::value));
    }

    default List<FulfilmentItem> mapFulfilmentItem(GetOrderByIdQuery.FulfilmentNode source) {
        if (source == null || source.fulfilmentItems() == null ||
                source.fulfilmentItems().fulfilmentItemEdges() == null || source.fulfilmentItems().fulfilmentItemEdges().isEmpty()) {
            return new ArrayList<>();
        }

        return source.fulfilmentItems().fulfilmentItemEdges().stream()
                .map(edge -> fulfilmentItemMapper.toFulfilmentItemModel(edge.fulfilmentItemNode()))
                .collect(Collectors.toList());
    }
}
