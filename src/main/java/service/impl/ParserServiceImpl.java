package service.impl;

import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> lines) {
        return lines.stream()
                .map(this::getTransactionFromLine)
                .toList();
    }

    public FruitTransaction getTransactionFromLine(String line) {
        String[] parsedTransactionData = line.split(COMMA);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation
                .getOperationByCode(parsedTransactionData[OPERATION_INDEX]));
        fruitTransaction.setFruit(parsedTransactionData[FRUIT_INDEX]);
        fruitTransaction.setAmount(Integer.parseInt(parsedTransactionData[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
