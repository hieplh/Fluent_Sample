package com.fluentcommerce.sample;

import com.config.CentralConfig;
import com.fluentcommerce.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.fulfilment.FulfilmentItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = CentralConfig.class)
public interface FulfilmentItemMapper {

    FulfilmentItemMapper INSTANCE = Mappers.getMapper(FulfilmentItemMapper.class);

    @Mapping(target = "id", expression = "java(source.id())")
    @Mapping(target = "ref", expression = "java(source.ref())")
    FulfilmentItem toFulfilmentItemModel(GetOrderByIdQuery.FulfilmentItemNode source);
}
