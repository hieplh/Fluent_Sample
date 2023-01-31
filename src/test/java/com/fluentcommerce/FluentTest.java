package com.fluentcommerce;

import com.fluentcommerce.sample.OrderMapper;
import com.fluentcommerce.graphql.query.order.GetOrderByIdQuery;
import com.fluentcommerce.model.order.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FluentTest {

    @Test
    public void test() {
        GetOrderByIdQuery.OrderById orderById = GetOrderByIdQuery.OrderById
                .builder()
                .id("2103")
                .ref("DKS_1667805211")
                .type("HD")
                .status("PICK_PACK")
                .createdOn("2022-11-07T07:13:31.394Z")
                .__typename("STRING")
                .orderAttributes(initOrderAttributes())
                .fulfilments(GetOrderByIdQuery.Fulfilments
                        .builder()
                        .fulfilmentEdges(initFulfilments())
                        .__typename("STRING")
                        .build())
                .build();

        Order order = OrderMapper.INSTANCE.toOrderModel(orderById);
        System.out.println(order);
    }

    List<GetOrderByIdQuery.OrderAttribute> initOrderAttributes() {
        return new ArrayList<GetOrderByIdQuery.OrderAttribute>() {{
            add(GetOrderByIdQuery.OrderAttribute.builder()
                    .type("STRING")
                    .__typename("STRING")
                    .name("discountCalculationErrorMessage")
                    .value("")
                    .build());
            add(GetOrderByIdQuery.OrderAttribute.builder()
                    .type("STRING")
                    .__typename("STRING")
                    .name("deliveryTime")
                    .value("10:00:00")
                    .build());
            add(GetOrderByIdQuery.OrderAttribute.builder()
                    .type("STRING")
                    .__typename("STRING")
                    .name("wmsOrderType")
                    .value("CustomerOrderGW")
                    .build());
        }};
    }

    List<GetOrderByIdQuery.FulfilmentEdge> initFulfilments() {
        return new ArrayList<GetOrderByIdQuery.FulfilmentEdge>() {{
            add(GetOrderByIdQuery.FulfilmentEdge.builder()
                    .__typename("STRING")
                    .fulfilmentNode(GetOrderByIdQuery.FulfilmentNode.builder()
                            .type("STRING")
                            .__typename("STRING")
                            .id("1307")
                            .ref("1707d6f3-da27-47c7-966a-ed931bb60338")
                            .type("HD_PFDC")
                            .status("PICK_PACK")
                            .fulfilmentAttributes(initFulfilmentAttributes())
                            .fulfilmentItems(initFulfilmentItems())
                            .build())
                    .build());
        }};
    }

    List<GetOrderByIdQuery.FulfilmentAttribute> initFulfilmentAttributes() {
        return new ArrayList<GetOrderByIdQuery.FulfilmentAttribute>() {{
            add(GetOrderByIdQuery.FulfilmentAttribute.builder()
                    .type("STRING")
                    .__typename("STRING")
                    .name("FulfilmentType")
                    .value("HD_PFDC")
                    .build());
        }};
    }

    GetOrderByIdQuery.FulfilmentItems initFulfilmentItems() {
        return GetOrderByIdQuery.FulfilmentItems.builder()
                .fulfilmentItemEdges(initFulfilmentItemEdge())
                .__typename("STRING")
                .build();
    }

    List<GetOrderByIdQuery.FulfilmentItemEdge> initFulfilmentItemEdge() {
        return new ArrayList<GetOrderByIdQuery.FulfilmentItemEdge>(){{
            add(GetOrderByIdQuery.FulfilmentItemEdge.builder()
                    .fulfilmentItemNode(GetOrderByIdQuery.FulfilmentItemNode.builder()
                            .id("1558")
                            .ref("DK008145BLK100M000")
                            .__typename("STRING")
                            .build())
                    .__typename("STRING")
                    .build());
        }};
    }
}
