package cn.lshenq.api.order.rest;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order extends ResourceSupport {

    private final String orderNo;

    @JsonCreator
    public Order(@JsonProperty("orderNo") String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }
}
