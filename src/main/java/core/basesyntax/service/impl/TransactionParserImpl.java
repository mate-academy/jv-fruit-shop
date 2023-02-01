package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {

    @Override
    public List<FruitTransaction> parseInputDate(List<String> listOfOperations) {
        List<FruitTransaction> result = new ArrayList<>();
        String[] splitString;
        for (int i = 1; i < listOfOperations.size(); i++) {
            splitString = listOfOperations.get(i).split(",");
            if (splitString.length > 3) {
                throw new RuntimeException("incorrectly entered data");
            }
            result.add(new FruitTransaction(splitString[0],splitString[1],
                    Integer.parseInt(splitString[2])));
        }
        return result;
    }
}
