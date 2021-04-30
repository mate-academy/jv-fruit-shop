package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.model.dao.FruitDao;
import com.companyname.fruitshop.model.dao.FruitDaoImpl;
import com.companyname.fruitshop.model.dto.FruitRecordDto;
import com.companyname.fruitshop.service.interfaces.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        fruitDao.add(fruitRecordDto);
        return fruitDao.getCurrentQuantity(fruitRecordDto);
    }
}
