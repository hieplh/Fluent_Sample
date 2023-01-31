package com.fluentcommerce.model.order;

import com.fluentcommerce.model.customer.Customer;
import com.fluentcommerce.model.fulfilment.Fulfilment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private String ref;
    private String type;
    private String status;
    private Date createdOn;

    private List<OrderItem> items;

    @Nullable
    private String pickupLocationRef;

    @Nullable
    private String deliveryType;

    @Nullable
    private String deliveryAddressId;

    @Nullable
    private String deliveryAddressRef;

    @Nullable
    private String deliveryAddressType;

    @Nullable
    private String deliveryAddressName;

    @Nullable
    private String deliveryAddressCompanyName;

    @Nullable
    private String deliveryAddressStreet;

    @Nullable
    private String deliveryAddressCity;

    @Nullable
    private String deliveryAddressState;

    @Nullable
    private String deliveryAddressPostcode;

    @Nullable
    private String deliveryAddressRegion;

    @Nullable
    private String deliveryAddressCountry;

    @Nullable
    private Double deliveryAddressLongitude;

    @Nullable
    private Double deliveryAddressLatitude;

    @Nullable
    private Map<String, Object> attributes;

    @Nullable
    private Customer customer;

    private List<Fulfilment> fulfilments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order that = (Order) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString(1);
    }
}
