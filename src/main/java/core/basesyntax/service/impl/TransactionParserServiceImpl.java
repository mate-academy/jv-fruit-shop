package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {

    private static final String SPLIT_KEY = ",";
    private static final Integer ACTION_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;

    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> allLines = new ArrayList<>();
        if (data.size() < 1) {
            throw new NullPointerException("File is empty");
        }
        for (int i = 1; i < data.size(); i++) {
            String[] line = data.get(i).split(SPLIT_KEY, 3);
            allLines.add(
                    new FruitTransaction(
                            FruitTransaction.Operation.getOperationByCode(line[ACTION_INDEX]),
                            line[FRUIT_INDEX],
                            Integer.parseInt(line[QUANTITY_INDEX])));
        }
        return allLines;
    }
}
