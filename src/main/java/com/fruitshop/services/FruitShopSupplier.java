package com.fruitshop.services;

import com.fruitshop.model.Fruit;
import java.util.List;
import java.util.Map;

public interface FruitShopSupplier {
    Map<String, Fruit> fillTheMap(List<String> listWithFruits);
}
