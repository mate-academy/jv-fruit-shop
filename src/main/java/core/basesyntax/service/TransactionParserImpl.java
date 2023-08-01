package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;

public class TransactionParserImpl implements TransactionParser {
    @Override
    public ArrayList<FruitTransaction> parseCsvRow(ArrayList<String> csvRowList) {
        ArrayList<FruitTransaction> output = new ArrayList<>();

        for (String s : csvRowList) {
            var temp = s.split(",");
            Operation operation = Operation.getType(temp[0]);
            String fruit = temp[1];
            int quantity = Integer.parseInt(temp[2].trim());

            output.add(new FruitTransaction(operation, fruit, quantity));
        }

        return output;
    }
}
