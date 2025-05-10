package core.basesyntax;

import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int LINE_LENGTH = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> dataFromFile) {
        if (dataFromFile.isEmpty()) {
            throw new RuntimeException("Empty list!");
        }
        return dataFromFile.stream()
                .skip(1)
                .map(line -> line.split(","))
                .filter(lines -> lines.length == LINE_LENGTH)
                .map(splitLine -> new FruitTransaction(FruitTransaction
                        .Operation.fromCode(splitLine[0]),
                        splitLine[1], Integer.parseInt(splitLine[2])))
                .collect(Collectors.toList());
    }
}
