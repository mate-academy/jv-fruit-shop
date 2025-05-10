package core.basesyntax.servise.impl;

import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OFFSET = 1;
    private static final String SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parsingData(List<String> inputList) {
        return inputList.stream()
                .skip(OFFSET)
                .map(line -> line.split(SEPARATOR))
                .map(array -> new FruitTransaction(
                        array[TYPE_INDEX],
                        array[FRUIT_INDEX],
                        Integer.parseInt(array[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
