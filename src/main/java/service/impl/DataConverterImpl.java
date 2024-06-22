package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final String REGEX = ",";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int FIRST_DATA_LINE = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> listOfFruitTransactions = new ArrayList<>();
        for (int i = FIRST_DATA_LINE; i < lines.size(); i++) {
            String[] strings = lines.get(i).split(REGEX);
            if (strings.length != 3) {
                throw new RuntimeException("The data in file don't separate by comma");
            }
            listOfFruitTransactions.add(new FruitTransaction(getOperation(strings[TYPE]),
                    strings[FRUIT], Integer.parseInt(strings[QUANTITY])));
        }
        return listOfFruitTransactions;
    }

    private Operation getOperation(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown operation \"" + code + "\" in source file");
    }
}
