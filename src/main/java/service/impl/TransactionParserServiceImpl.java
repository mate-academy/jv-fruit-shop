package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.TransactionParserService;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .map(this::getFromRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromRow(String line) {
        String[] fields = line.split(COMMA);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.getByCode(fields[OPERATION_INDEX]));
        transaction.setFruit(fields[FRUIT_NAME_INDEX]);
        transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return transaction;
    }
}
