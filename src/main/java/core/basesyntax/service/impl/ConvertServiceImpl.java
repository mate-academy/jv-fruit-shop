package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.service.ConvertService;
import java.util.ArrayList;
import java.util.List;

public class ConvertServiceImpl implements ConvertService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_BY_TRANSACTION = 0;
    private static final int INDEX_BY_FRUIT = 1;
    private static final int INDEX_BY_AMOUNT = 2;

    @Override
    public List<FruitTransaction> proccesing(List<String> strings) {
        List<FruitTransaction> dataFruitTransaction = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String[] data = strings.get(i).split(SEPARATOR);
            dataFruitTransaction
                    .add(new FruitTransaction(parseStringToOperation(data[INDEX_BY_TRANSACTION]),
                    data[INDEX_BY_FRUIT], Integer.parseInt(data[INDEX_BY_AMOUNT])));
        }
        return dataFruitTransaction;
    }

    private Operation parseStringToOperation(String letter) {
        switch (letter) {
            case "b":
                return Operation.BALANCE;
            case "r":
                return Operation.RETURN;
            case "p":
                return Operation.PURCHASE;
            case "s":
                return Operation.SUPPLY;
            default:
                throw new RuntimeException("not appropriate symbol for operation");
        }
    }
}
