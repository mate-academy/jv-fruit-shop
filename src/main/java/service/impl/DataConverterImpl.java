package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA_SEPARATOR = ",";
    private static final int OPERATION_PARAMETER = 0;
    private static final int FRUIT_PARAMETER = 1;
    private static final int QUANTITY_PARAMETER = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < report.size(); i++) {
            FruitTransaction fruitTransaction = getFromCsvRow(report.get(i));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

    private FruitTransaction getFromCsvRow(String row) {
        String[] fields = row.split(COMMA_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.getOperationFromCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
