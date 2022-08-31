package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;
    private static final String COMA = ",";

    @Override
    public List<Transaction> parse(List<String> lines) {
        lines.remove(ZERO_INDEX);
        return lines.stream()
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private Transaction getTransaction(String string) {
        String[] splittedStrings = string.trim().split(COMA);
        return new Transaction(splittedStrings[ZERO_INDEX],
                new Fruit(splittedStrings[FIRST_INDEX]),
                Integer.parseInt(splittedStrings[SECOND_INDEX]));
    }
}
