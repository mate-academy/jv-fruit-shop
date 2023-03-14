package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseDataService;
import java.util.ArrayList;
import java.util.List;

public class ParseDataServiceImpl implements ParseDataService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_CODE_FIELD = 0;
    private static final int FRUIT_FIELD = 1;
    private static final int QUANTITY_FIELD = 2;
    private static final int START_LINE_WITHOUT_TITLE = 1;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> outData = new ArrayList<>();
        for (int i = START_LINE_WITHOUT_TITLE; i < data.size(); i++) {
            outData.add(parseLine(data.get(i)));
        }
        return outData;
    }

    private FruitTransaction parseLine(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = line.split(SEPARATOR);
        fruitTransaction
                .setOperation(FruitTransaction.Operation.getByCode(fields[OPERATION_CODE_FIELD]));
        fruitTransaction.setFruit(fields[FRUIT_FIELD]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_FIELD]));
        return fruitTransaction;
    }
}
