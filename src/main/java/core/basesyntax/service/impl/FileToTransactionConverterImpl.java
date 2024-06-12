package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.FileToTransactionConverter;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FileToTransactionConverterImpl implements FileToTransactionConverter {
    private static final int TITLE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        lines.remove(TITLE_INDEX);//remove line with (type,fruit,quantity)
        return lines.stream()
                .map(this::toFruitTransaction)
                .toList();
    }

    private FruitTransaction toFruitTransaction(String line) {
        String[] strings = line.split(",");
        return new FruitTransaction(
                Operation.fromCode(strings[OPERATION_INDEX])
                , strings[FRUIT_INDEX]
                , Integer.parseInt(strings[AMOUNT_INDEX])
        );
    }
}
