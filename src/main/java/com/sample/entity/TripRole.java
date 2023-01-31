package com.sample.entity;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TripRole {

	private String id;

	private String name;
	
	private String description;

	private Boolean deletable;

	private Set<TripPermission> permissions = new HashSet<>();
}
