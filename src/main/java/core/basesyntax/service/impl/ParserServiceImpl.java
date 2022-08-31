package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String DATA_SPLITTER = ",";
    private static final int HEADER_LINE_SKIP_INDEX = 1;
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> lines) {
        return lines.stream()
                .skip(HEADER_LINE_SKIP_INDEX)
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private Transaction getTransaction(String line) {
        String[] splitted = line.split(DATA_SPLITTER);
        return new Transaction(splitted[TYPE_INDEX],
            new Fruit(splitted[FRUIT_NAME_INDEX]),
            Integer.parseInt(splitted[FRUIT_AMOUNT_INDEX]));
    }
}
