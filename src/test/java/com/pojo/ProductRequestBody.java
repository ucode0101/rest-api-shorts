package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // include getter, setter, toString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestBody {

    private String name;
    private double price;
}
