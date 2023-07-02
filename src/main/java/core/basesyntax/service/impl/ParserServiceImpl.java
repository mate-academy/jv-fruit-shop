package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String[]> fileInfo) {
        return fileInfo.stream()
                .skip(1)
                .map(line -> {
                    String[] splittedLine = line[0].split(";");
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(FruitTransaction.Operation
                            .identifyOperation(splittedLine[TYPE_INDEX]));
                    fruitTransaction.setFruitName(splittedLine[FRUIT_INDEX]);
                    fruitTransaction
                            .setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]));
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }
}
