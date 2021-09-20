package com.example.java_base;

import com.example.pojo.Calculate;
import com.example.pojo.CalculateInterface;

/**
 * @author rds
 * @date 2021-09-18 18:59
 **/
public class CalculateProxy implements CalculateInterface {
    private Calculate calculate;

    public CalculateProxy(Calculate calculate) {
        this.calculate = calculate;
    }

    @Override
    public void add() {
        System.out.println("add前");
        calculate.add();
        System.out.println("add后");

    }

    @Override
    public void reduce() {
        System.out.println("reduce前");
        calculate.add();
        System.out.println("reduce后");
    }
}
