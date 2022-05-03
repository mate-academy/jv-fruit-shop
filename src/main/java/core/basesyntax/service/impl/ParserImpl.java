package core.basesyntax.service.impl;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    public List<Transaction> parse(List<String> list) {
        List<Transaction> transactionsList = new ArrayList<>();
        for (String string:list) {
            if (isTransactionFormatIncorrect(string)) {
                continue;
            }
            String[] stringsFromInput = string.split(",");
            String type = stringsFromInput[0];
            String name = stringsFromInput[1];
            Integer amount = Integer.parseInt(stringsFromInput[2]);
            transactionsList.add(new Transaction(type, new Fruit(name), amount));
        }
        return transactionsList;
    }

    private boolean isTransactionFormatIncorrect(String line) {
        return line.charAt(1) != ',';
    }
}
