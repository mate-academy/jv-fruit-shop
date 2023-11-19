package service.impl;

import db.FruitShopDao;
import java.util.List;
import model.FruitTransaction;
import service.ProcessCsvDataService;
import strategy.FruitStrategy;
import strategy.OperationHandler;

public class ProcessCsvDataServiceImpl implements ProcessCsvDataService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private FruitShopDao fruitShopDao;
    private FruitStrategy fruitStrategy;

    public ProcessCsvDataServiceImpl(FruitShopDao fruitShopDao, FruitStrategy fruitStrategy) {
        this.fruitShopDao = fruitShopDao;
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void processData(List<String> rawData) {
        if (rawData == null) {
            throw new RuntimeException("Incorrect data passed!");
        }
        for (int i = 1; i < rawData.size(); i++) {
            String[] csvFields = rawData.get(i).split(SEPARATOR);
            String fruitName = csvFields[FRUIT_INDEX];
            if (Integer.parseInt(csvFields[QUANTITY_INDEX]) < 0) {
                throw new RuntimeException("Quantity can't be less then 0!");
            }
            int quantity = Integer.parseInt(csvFields[QUANTITY_INDEX]);
            int newQuantity = fruitStrategy.getOperationHandler(FruitTransaction.Operation
                            .getOperationFromCode(csvFields[OPERATION_INDEX]))
                    .handleOperation(fruitName, quantity);

            fruitShopDao.add(fruitName, newQuantity);
        }
    }
}
