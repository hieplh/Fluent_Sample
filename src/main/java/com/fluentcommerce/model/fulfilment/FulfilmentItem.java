/*
 * Copyright (C)  Fluent Retail Pty Ltd - 2022.  - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.fluentcommerce.model.fulfilment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FulfilmentItem {

    private String id;
    private String ref;
    private String productRef;
    private String productName;
    private Integer requestedQuantity;
    private Integer filledQuantity;
    private Integer rejectedQuantity;

    public int getRequestedQuantity() {
        return requestedQuantity == null ? 0 : requestedQuantity;
    }

    public int getFilledQuantity() {
        return filledQuantity == null ? 0 : filledQuantity;
    }

    public int getRejectedQuantity() {
        return rejectedQuantity == null ? 0 : rejectedQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FulfilmentItem that = (FulfilmentItem) o;
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
