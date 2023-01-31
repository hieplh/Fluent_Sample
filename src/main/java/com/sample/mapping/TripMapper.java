package com.sample.mapping;

import com.config.CentralConfig;
import com.config.CommonMapper;
import com.sample.entity.Trip;
import com.sample.request.TripRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = CentralConfig.class, uses = {CommonMapper.class})
public interface TripMapper {

    TripMapper INSTANCE = Mappers.getMapper(TripMapper.class);

    @Mapping(target = "id", constant = )
    @Mapping(target = "title", source = "title", defaultValue = "Default Value")
    @Mapping(target = "roles", ignore = true)
    Trip toTripEntity(TripRequest source);
}
