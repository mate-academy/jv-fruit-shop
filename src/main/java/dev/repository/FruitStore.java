package dev.repository;

import java.util.Map;

public interface FruitStore {
    Integer selectQuantity(String fruitKey);

    void updateQuantity(String fruitKey, int newQuantity);

    Map<String, Integer> selectAll();
}
