package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author desener
 * @date 2021-09-0610:30
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Drink implements Comparable<Drink>{
    private String productName; //饮料名称
    private int capacitance; //容量


    @Override
    public int compareTo(Drink drink) {
        return this.capacitance - drink.capacitance;
    }
}