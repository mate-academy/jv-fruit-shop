package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA_SPLITTER = ",";
    private static final int COMMAND_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> line) {
        return line.stream()
                .map(this::fruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction fruitTransaction(String line) {
        String[] splitLine = line.split(COMMA_SPLITTER);
        return new FruitTransaction(FruitTransaction.Operation
                .getByOperationCode(splitLine[COMMAND_INDEX]),
                splitLine[FRUIT_INDEX], Integer.parseInt(splitLine[QUANTITY_INDEX]));
    }
}
