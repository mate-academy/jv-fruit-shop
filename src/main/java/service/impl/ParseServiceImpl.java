package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {

    private static final int OPERATION_CODE_INDEX = 0;
    private static final int FRUIT_CODE_INDEX = 1;
    private static final int QUANTITY_CODE_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            fruitTransactionList.add(getFromCvsRow(lines.get(i)));
        }
        return fruitTransactionList;
    }

    private FruitTransaction getFromCvsRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        String operationCode = fields[OPERATION_CODE_INDEX].trim();
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(operationCode);

        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[FRUIT_CODE_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_CODE_INDEX]));
        return fruitTransaction;
    }
}
