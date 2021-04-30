package com.companyname.fruitshop.model.dao;

import com.companyname.fruitshop.model.Fruit;
import com.companyname.fruitshop.model.dto.FruitRecordDto;

import java.util.Map;

public interface FruitDao {
    void add(FruitRecordDto fruitRecordDto);
    void updateQuantity(FruitRecordDto fruitRecordDto, int quantity);
    Map<Fruit, Integer> getAll();
    int getCurrentQuantity(FruitRecordDto fruitRecordDto);
}
