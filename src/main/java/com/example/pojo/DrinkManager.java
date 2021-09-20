package com.example.pojo;

import java.util.Map;

/**
 * @author rds
 * @date 2021-09-16 19:14
 **/
public class DrinkManager {
    private static Map<String,Drink>  drinkMapping;

    public static Map<String, Drink> getDrinkMapping() {
        return drinkMapping;
    }

    public static void setDrinkMapping(Map<String, Drink> drinkMapping) {
        DrinkManager.drinkMapping = drinkMapping;
    }
}
