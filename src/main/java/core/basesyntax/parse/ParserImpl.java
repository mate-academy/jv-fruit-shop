package core.basesyntax.parse;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    public List<Transaction> parse(List<String> list) {
        List<Transaction> transactionsList = new ArrayList<>();
        for (String string:list) {
            if (string.charAt(1) != ',') {
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
}
