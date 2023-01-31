package com.sample.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TripRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	@JsonProperty("start_date")
	private LocalDate startDate;

	@JsonProperty("end_date")
	private LocalDate endDate;

	@JsonProperty("type_access")
	private String type;

	@JsonProperty("total_price_plan")
	private String totalPricePlan;

	@JsonProperty("total_price_actual")
	private String totalPriceActual;

	@JsonProperty("roles")
	private Set<TripRoleRequest> roles;
}