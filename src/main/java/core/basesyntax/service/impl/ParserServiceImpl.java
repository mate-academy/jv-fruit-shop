package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String [] part = lines.get(i).split(REGEX);
            transactions.add(new Transaction(part[0],
                    new Fruit(part[1]), Integer.parseInt(part[2])));
        }
        return transactions;
    }
}
