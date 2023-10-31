package serviceimpl;

import java.util.List;
import model.FruitTransaction;
import model.Operation;
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
                .map(string -> string.split(COMMA))
                .map(stringList -> new FruitTransaction(Operation
                        .findRightOperation(stringList[INDEX_FOR_OPERATION]),
                        stringList[INDEX_FOR_FRUITS],
                        Integer.parseInt(stringList[INDEX_FOR_NUMBER])))
                .toList();
    }
}
