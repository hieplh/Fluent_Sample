package com.sample.request;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TripRoleRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private List<String> permissions;
}
