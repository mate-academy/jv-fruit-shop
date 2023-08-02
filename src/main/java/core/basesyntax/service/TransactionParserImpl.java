package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public ArrayList<FruitTransaction> parseCsvRow(ArrayList<String> csvRowList) {
        ArrayList<FruitTransaction> output = new ArrayList<>();

        for (String s : csvRowList) {
            String[] rowSplit = s.split(",");
            output.add(
                    new FruitTransaction(
                            Operation.getType(rowSplit[OPERATION_TYPE_INDEX]),
                            rowSplit[FRUIT_NAME_INDEX],
                            Integer.parseInt(rowSplit[QUANTITY_INDEX].trim())));
        }

        return output;
    }
}
