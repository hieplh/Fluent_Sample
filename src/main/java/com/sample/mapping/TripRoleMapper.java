package com.sample.mapping;

import com.config.CentralConfig;
import com.config.CommonMapper;
import com.sample.entity.TripPermission;
import com.sample.entity.TripRole;
import com.sample.request.TripRoleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(config = CentralConfig.class, uses = {CommonMapper.class})
public interface TripRoleMapper {

    TripRoleMapper INSTANCE = Mappers.getMapper(TripRoleMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "deletable", ignore = true)
    @Mapping(target = "permissions", expression = "java(requestPermissionsToTripPermissions(source.getPermissions()))")
    TripRole toTripRole(TripRoleRequest source);

    default Set<TripPermission> requestPermissionsToTripPermissions(List<String> permissions) {
        Set<TripPermission> setPermissions = new HashSet<>();
        if (permissions != null && !permissions.isEmpty()) {
            permissions.forEach(permission -> setPermissions.add(new TripPermission(null, permission, null)));
        }
        return setPermissions;
    }
}
