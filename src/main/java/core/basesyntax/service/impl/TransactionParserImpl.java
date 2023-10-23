package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseCsvRows(List<String> csvRowList) {
        List<FruitTransaction> output = new ArrayList<>();

        for (String row : csvRowList) {
            String[] rowSplit = row.split(",");
            output.add(
                    new FruitTransaction(
                            Operation.getType(rowSplit[OPERATION_TYPE_INDEX]),
                            rowSplit[FRUIT_NAME_INDEX],
                            Integer.parseInt(rowSplit[QUANTITY_INDEX].trim())));
        }

        return output;
    }

}
