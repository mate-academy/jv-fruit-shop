package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParsingServiceImpl implements ParsingService {
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(splittedLine ->
                        new FruitTransaction(FruitTransaction.Operation
                                .getOperation(splittedLine[TYPE_OPERATION_INDEX]),
                                splittedLine[FRUIT_NAME_INDEX],
                                Integer.parseInt(splittedLine[QUANTITY_INDEX])
                        )
                )
                .collect(Collectors.toList());
    }
}
