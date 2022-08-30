package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final String DATA_SPLITTER = ",";
    private static final int HEADER_LINE_SKIP_INDEX = 1;
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> lines) {
        return lines.stream()
                .skip(HEADER_LINE_SKIP_INDEX)
                .map(this::getRowFromFile)
                .collect(Collectors.toList());
    }

    private Transaction getRowFromFile(String line) {
        String[] splitted = line.split(DATA_SPLITTER);
        return new Transaction(splitted[TYPE_INDEX],
            new Fruit(splitted[FRUIT_NAME_INDEX]),
            Integer.parseInt(splitted[FRUIT_AMOUNT_INDEX]));
    }
}
