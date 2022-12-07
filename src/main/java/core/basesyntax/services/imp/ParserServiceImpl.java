package core.basesyntax.services.imp;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements TransactionParser {
    private static final int USLESS_LINE = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        lines.remove(USLESS_LINE);
        return lines.stream()
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(identifyOperation(s[OPERATION_INDEX]),
                        s[FRUIT_NAME_INDEX],
                        Integer.parseInt(s[AMOUNT_INDEX])))
                .collect(Collectors.toList());

    }

    private FruitTransaction.Operation identifyOperation(String inputOperation) {
        for (FruitTransaction.Operation operation: FruitTransaction.Operation.values()) {
            String operationFromEnum = operation.getOperation();
            if (operationFromEnum.equals(inputOperation)) {
                return operation;
            }
        }
        throw new RuntimeException("Cant find operation from input code");
    }
}

