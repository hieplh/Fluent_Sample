package com.fluentcommerce.model.fulfilment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fulfilment {

    private String id;
    private String ref;
    private String type;
    private List<FulfilmentItem> items;

    @Nullable
    private String status;
    
    @Nullable
    private String eta;

    @Nullable
    private String deliveryType;

    @Nullable
    private String fromLocationRef;

    @Nullable
    private Map<String, Object> attributes;

    @Nullable
    private String orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fulfilment that = (Fulfilment) o;
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
