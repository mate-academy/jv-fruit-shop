package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    @Override
    public List<String[]> parseInputDate(List<String> listOfOperations) {
        List<String[]> result = new ArrayList<>();
        for (int i = 1; i < listOfOperations.size(); i++) {
            result.add(listOfOperations.get(i).split(","));
        }
        return result;
    }
}
