package com.config;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(config = CentralConfig.class)
public interface CommonMapper {

    CommonMapper INSTANCE = Mappers.getMapper(CommonMapper.class);

    default Long convertNumber(String source) {
      return Long.parseLong(source);
    }

    @Named("stringToLong")
    default Long stringToLong(String source) {
        return Long.parseLong(source);
    }
}
