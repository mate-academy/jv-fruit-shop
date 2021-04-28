package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.dao.FruitDao;
import com.companyname.fruitshop.model.Fruit;
import com.companyname.fruitshop.model.Operation;
import com.companyname.fruitshop.service.interfaces.FruitService;
import com.companyname.fruitshop.service.interfaces.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void doSomething(Fruit fruit, Operation operation) {
    }
}
