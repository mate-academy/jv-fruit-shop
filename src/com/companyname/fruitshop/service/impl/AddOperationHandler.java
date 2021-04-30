package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.model.dao.FruitDao;
import com.companyname.fruitshop.model.dao.FruitDaoImpl;
import com.companyname.fruitshop.model.dto.FruitRecordDto;
import com.companyname.fruitshop.service.interfaces.OperationHandler;

public class AddOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public AddOperationHandler() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        int currentQuantity = fruitDao.getCurrentQuantity(fruitRecordDto);
        int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
        fruitDao.updateQuantity(fruitRecordDto, newQuantity);
        return newQuantity;
    }
}
