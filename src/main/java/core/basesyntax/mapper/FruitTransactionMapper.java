package core.basesyntax.mapper;

import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionMapper {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    public List<Transaction> mapToTransactions(List<String> lines) {
        final List<Transaction> transactions = lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(this::mapToOneTransaction)
                .collect(Collectors.toList());
        return transactions;
    }

    private Transaction mapToOneTransaction(String[] partedLine) {
        Transaction.Operation operation = Transaction.Operation
                .getOperationByCode(partedLine[OPERATION_INDEX]);
        String fruitName = partedLine[FRUIT_INDEX];
        int amount = Integer.valueOf(partedLine[AMOUNT_INDEX]);
        return new Transaction(operation, fruitName, amount);

    }
}
