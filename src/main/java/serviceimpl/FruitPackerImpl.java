package serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitPacker;

public class FruitPackerImpl implements FruitPacker {
    public static final String COMMA = ",";
    private static final String NOT_NULL_MESSAGE = "List can not be null";
    private static final int INDEX_FOR_OPERATION = 0;
    private static final int INDEX_FOR_FRUITS = 1;
    private static final int INDEX_FOR_NUMBER = 2;

    public List<FruitTransaction> makeList(List<String> transactionListString) {
        if (transactionListString == null) {
            throw new RuntimeException(NOT_NULL_MESSAGE);
        }
        return transactionListString.stream()
                .map(e -> e.split(COMMA))
                .map(e -> new FruitTransaction(FruitTransaction
                        .Operation.findRightOperation(e[INDEX_FOR_OPERATION]),
                        e[INDEX_FOR_FRUITS],
                        Integer.parseInt(e[INDEX_FOR_NUMBER])))
                .collect(Collectors.toList());
    }
}
