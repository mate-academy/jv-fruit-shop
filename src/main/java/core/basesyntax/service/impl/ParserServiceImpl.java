package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<Transaction> parse(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        lines.stream().skip(1).map(line -> line.split(COMMA)).forEach(fields -> {
            Transaction transaction = new Transaction();
            transaction.setOperation(fields[OPERATION_INDEX]);
            transaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
            transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
            transactions.add(transaction);
        });
        return transactions;
    }
}
