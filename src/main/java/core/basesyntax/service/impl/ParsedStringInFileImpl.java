package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParsedStringInFile;
import java.util.List;
import java.util.stream.Collectors;

public class ParsedStringInFileImpl implements ParsedStringInFile {
    private static final String CHAR_FOR_SPLIT = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int COUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fromFile) {
        fromFile.remove(0);
        return fromFile.stream().map(s -> s.split(CHAR_FOR_SPLIT)).map(strings ->
                        new FruitTransaction(strings[OPERATION_INDEX],
                        new Fruit(strings[FRUIT_INDEX]), Integer.parseInt(strings[COUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
