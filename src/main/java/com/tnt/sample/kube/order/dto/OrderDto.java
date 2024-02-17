package com.tnt.sample.kube.order.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    Long id;
    String itemName;
    Integer qty;
    Double price;

}
