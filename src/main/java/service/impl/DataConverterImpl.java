package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final String REGEX = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> listOfFruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] strings = lines.get(i).split(REGEX);
            listOfFruitTransactions.add(new FruitTransaction(getOperation(strings[TYPE]),
                    strings[FRUIT], Integer.parseInt(strings[QUANTITY])));
        }
        return listOfFruitTransactions;
    }

    private FruitTransaction.Operation getOperation(String string) {
        return switch (string) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new RuntimeException("unknown operation in source file");
        };
    }
}
