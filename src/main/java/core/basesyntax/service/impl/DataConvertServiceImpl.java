package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConvertService;
import java.util.ArrayList;
import java.util.List;

public class DataConvertServiceImpl implements DataConvertService {
    private static final String SPLIT_CHARACTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(List<String> fruits) {
        List<FruitTransaction> fruitsTransactionsInfo = new ArrayList<>();

        for (String fruitInfo : fruits) {
            fruitsTransactionsInfo.add(new FruitTransaction(getOperation(fruitInfo),
                    getFruitName(fruitInfo),
                    getQuantity(fruitInfo)));
        }

        return fruitsTransactionsInfo;
    }

    private int getQuantity(String fruitInfo) {
        return Integer.parseInt(fruitInfo.split(SPLIT_CHARACTER)[QUANTITY_INDEX]);
    }

    private String getFruitName(String fruitInfo) {
        return fruitInfo.split(SPLIT_CHARACTER)[FRUIT_NAME_INDEX];
    }

    private Operation getOperation(String fruitInfo) {
        String code = fruitInfo.split(SPLIT_CHARACTER)[OPERATION_INDEX];
        return Operation.findByCode(code);
    }
}
