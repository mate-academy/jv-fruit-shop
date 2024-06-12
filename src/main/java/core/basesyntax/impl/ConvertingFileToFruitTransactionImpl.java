package core.basesyntax.impl;

import core.basesyntax.service.ConvertingFileToFruitTransaction;
import core.basesyntax.service.FruitTransaction;

import java.util.List;

public class ConvertingFileToFruitTransactionImpl implements ConvertingFileToFruitTransaction {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        lines.remove(0);//remove line with (type,fruit,quantity)
        return lines.stream()
                .map(n -> toFruitTransaction(n))
                .toList();
    }
    private FruitTransaction toFruitTransaction(String line) {
        String[] strings = line.split(",");
        return new FruitTransaction()
                .setOperation(FruitTransaction.Operation.fromCode(strings[OPERATION_INDEX]))
                .setFruit(strings[FRUIT_INDEX])
                .setQuantity(Integer.parseInt(strings[AMOUNT_INDEX]));
    }
}
