package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.model.dto.FruitRecordDto;
import com.companyname.fruitshop.service.interfaces.FruitService;
import com.companyname.fruitshop.service.interfaces.OperationStrategy;
import com.companyname.fruitshop.service.interfaces.ParserService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;
    private final ParserService parserService;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        parserService = new ParserServiceImpl();
    }

    @Override
    public void saveData(List<String> data) {
        data.stream()
                .map(parserService::parse)
                .forEach(this::applyStrategy);
    }

    @Override
    public String getReport() {
        return null;
    }

    private void applyStrategy(FruitRecordDto fruitRecord) {
        operationStrategy.get(fruitRecord.getOperation()).apply(fruitRecord);
    }
}
