package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private static final int HEADER = 0;

    @Override
    public List<FruitTransaction> parse(List<String> fromFile) {
        fromFile.remove(HEADER);
        return fromFile.stream().map(s -> s.split(COMMA)).map(strings ->
                        new FruitTransaction(strings[OPERATION_INDEX],
                        new Fruit(strings[FRUIT_INDEX]), Integer.parseInt(strings[COUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
