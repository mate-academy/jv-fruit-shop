package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String PUNCTUATION_MARK = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> dataFromFile) {
        if (dataFromFile.isEmpty()) {
            throw new RuntimeException("Empty list!");
        }
        return dataFromFile.stream()
                .skip(1)
                .map(line -> line.split(PUNCTUATION_MARK))
                .map(lines -> {
                    if (lines.length != 3) {
                        throw new RuntimeException("Wrong data: " + lines);
                    }
                    return lines;
                })
                .map(splitLine -> new FruitTransaction(FruitTransaction
                        .Operation.fromCode(splitLine[0]),
                        splitLine[1], Integer.parseInt(splitLine[2])))
                .toList();
    }
}
