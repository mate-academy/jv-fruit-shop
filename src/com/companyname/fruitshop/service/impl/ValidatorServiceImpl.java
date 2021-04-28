package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.model.Fruit;
import com.companyname.fruitshop.model.Operation;
import com.companyname.fruitshop.service.interfaces.ValidatorService;

import java.util.List;

public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public void validateData(List<String> data) {
        if (data.isEmpty() || data.size() == 1) {
            throw new RuntimeException("There is no data");
        }
        for (int i = 1; i < data.size(); i++) {
            String[] splitString = data.get(i).split(",");
            int count = Integer.parseInt(splitString[2]);
            String fruitName = splitString[1];
            Operation operation = Operation.valueOf(splitString[0]);
            Fruit fruit = new Fruit(count, fruitName);
        }
    }
}
