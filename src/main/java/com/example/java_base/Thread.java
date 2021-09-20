package com.example.java_base;

import com.example.pojo.Drink;
import com.example.pojo.DrinkManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * 线程相关
 */
public class Thread {
    public static void main(String[] args) {
        /*ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("a");*/
        Drink drink = new Drink("kele",20);
        Drink drink1 = new Drink("xuebi",20);
        HashMap<String, Drink> stringDrinkHashMap = new HashMap<>();
        stringDrinkHashMap.put("a",drink);
        stringDrinkHashMap.put("b",drink1);

        DrinkManager.setDrinkMapping(stringDrinkHashMap);
        new Runnable(){
            @Override
            public void run() {
                DrinkManager.getDrinkMapping().get("a").setCapacitance(DrinkManager.getDrinkMapping().get("a").getCapacitance()+20);
            }
        };

        new Runnable(){
            @Override
            public void run() {
                DrinkManager.getDrinkMapping().get("a").setCapacitance(DrinkManager.getDrinkMapping().get("a").getCapacitance()+20);
            }
        };

        System.out.println(DrinkManager.getDrinkMapping().get("a").getCapacitance()+20);





    }
}
