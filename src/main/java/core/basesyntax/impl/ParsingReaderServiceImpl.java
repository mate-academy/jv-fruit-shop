package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParsingReaderService;
import core.basesyntax.util.Operation;
import core.basesyntax.util.OperationUtil;
import java.util.List;

public class ParsingReaderServiceImpl implements ParsingReaderService {
    private String regexComma = ",";
    private String firstStringOfTheFile = "type,fruit,quantity";
    private int indexZero = 0;
    private int indexOne = 1;
    private int indexTwo = 2;

    @Override
    public List<FruitTransaction> getParsingValueFromFile(List<String> listStringsFromFile) {
        return listStringsFromFile.stream()
                .filter(e -> !e.equals(firstStringOfTheFile))
                .map(line -> {
                    String[] parts = line.split(regexComma);
                    Operation operation = Operation.valueOf(
                            OperationUtil.getCode(parts[indexZero].trim()));
                    return new FruitTransaction(
                            operation,
                            parts[indexOne].trim(),
                            Integer.parseInt(parts[indexTwo].trim())
                    );
                })
                .toList();
    }
}
