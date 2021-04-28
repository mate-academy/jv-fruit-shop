package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.dao.FruitDao;
import com.companyname.fruitshop.dao.FruitDaoImpl;
import com.companyname.fruitshop.model.Fruit;
import com.companyname.fruitshop.model.Operation;
import com.companyname.fruitshop.service.interfaces.ParseService;

import java.util.List;

public class ParseServiceImpl implements ParseService {
    @Override
    public void parseData(List<String> data) {
        FruitDao fruitDao = new FruitDaoImpl();
        for (int i = 1; i < data.size(); i++) {
            String[] splitString = data.get(i).split(",");
            int count = Integer.parseInt(splitString[2]);
            String fruitName = splitString[1];
            Operation operation = Operation.valueOf(splitString[0]);
            Fruit fruit = new Fruit(count, fruitName);
            fruitDao.add(fruit);
        }
    }
}
