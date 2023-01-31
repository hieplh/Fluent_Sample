package com.sample.entity;

import lombok.*;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripRole {

	private String id;

	private String name;
	
	private String description;

	private Boolean deletable;

	private Set<TripPermission> permissions = new HashSet<>();

	@Override
	public String toString() {
		return new JSONObject(this).toString(1);
	}
}
