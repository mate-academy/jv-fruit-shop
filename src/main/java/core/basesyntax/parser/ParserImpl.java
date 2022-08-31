package core.basesyntax.parser;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String DELIMITER = ",";

    @Override
    public List<Transaction> parse(String data) {
        List<Transaction> list = new ArrayList<>();
        for (String value : data.split(System.lineSeparator())) {
            list.add(normalize(value));
        }
        return list;
    }

    private Transaction normalize(String data) {
        String fruitName;
        String operationType;
        int quantity;
        quantity = Integer.parseInt(data.split(DELIMITER)[2].trim());
        fruitName = data.split(DELIMITER)[1].trim();
        operationType = data.split(DELIMITER)[0].trim();
        return new Transaction(new Fruit(fruitName), quantity, operationType);
    }
}
