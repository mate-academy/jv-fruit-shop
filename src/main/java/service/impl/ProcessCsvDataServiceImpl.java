package service.impl;

import db.FruitShopDao;
import java.util.List;
import model.Operation;
import service.ProcessCsvDataService;
import strategy.FruitStrategy;

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
    public String processData(List<String> rawData) {
        if (rawData == null) {
            throw new RuntimeException("Incorrect data passed!");
        }
        for (int i = 1; i < rawData.size(); i++) {
            processCsvRow(rawData.get(i));
        }
        return fruitShopDao.getAllFruitsAndQuantities().entrySet().stream().toList().toString();
    }

    private void processCsvRow(String csvRow) {
        String[] csvFields = csvRow.split(SEPARATOR);
        String fruitName = csvFields[FRUIT_INDEX];
        int quantityFromCsvRow = Integer.parseInt(csvFields[QUANTITY_INDEX]);

        if (quantityFromCsvRow < 0) {
            throw new RuntimeException("Quantity can't be less then 0!");
        }
        int newQuantity = fruitStrategy.getOperationHandler(Operation
                        .getOperationFromCode(csvFields[OPERATION_INDEX]))
                .handleOperation(fruitName, quantityFromCsvRow);
        fruitShopDao.put(fruitName, newQuantity);
    }
}
