package com.sample.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

	private String id;

	private String title;
	
	private LocalDate startDate;
	
	private LocalDate endDate;

	private LocalDateTime createDate;

	private Long totalPricePlan;

	private Long totalPriceActual;

	private Set<TripRole> roles = new HashSet<>();

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		return Objects.equals(id, other.id);
	}
}