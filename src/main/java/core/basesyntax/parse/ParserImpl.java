package core.basesyntax.parse;

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
            String type = string.substring(0, string.indexOf(','));
            string = string.substring(string.indexOf(',') + 1);
            String name = string.substring(0, string.indexOf(','));
            string = string.substring(string.indexOf(',') + 1);
            Integer amount = Integer.parseInt(string);
            transactionsList.add(new Transaction(type, name, amount));
        }
        return transactionsList;
    }
}
