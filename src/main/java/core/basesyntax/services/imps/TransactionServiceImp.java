package core.basesyntax.services.imps;

import core.basesyntax.FruitTransaction;
import core.basesyntax.services.TransactionService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImp implements TransactionService {
    private static final String LINE_SPLITERATOR = "/";
    private static final String SPLITERATOR = ",";
    private static final int HEADLINES_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> transactionProcessor(String fromFile) {
        return Arrays.stream(fromFile.split(LINE_SPLITERATOR))
                .skip(HEADLINES_INDEX)
                .map(line -> line.split(SPLITERATOR))
                .map(parts -> new FruitTransaction(FruitTransaction.Operation
                        .getOperationFromCode(
                                parts[OPERATION_INDEX]),
                        parts[FRUIT_INDEX],
                        Integer.parseInt(parts[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
