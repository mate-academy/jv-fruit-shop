package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int TYPE_OF_OPERATION_INDEX = 0;
    private static final int NAME_OF_FRUIT_INDEX = 1;
    private static final int QUANTITY_OF_FRUIT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(splittedLine -> new FruitTransaction(FruitTransaction.Operation
                        .getTypeOperation(splittedLine[TYPE_OF_OPERATION_INDEX]),
                        splittedLine[NAME_OF_FRUIT_INDEX],
                        Integer.parseInt(splittedLine[QUANTITY_OF_FRUIT_INDEX])))
                .collect(Collectors.toList());
    }
}
