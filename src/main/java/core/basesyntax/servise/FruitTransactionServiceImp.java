package core.basesyntax.servise;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionServiceImp implements FruitTransactionService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> createTransactionList(List<String> date) {
        return date.stream()
                .map(line -> line.split(SEPARATOR))
                .map(part -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(getOperationByCode(part[INDEX_OPERATION]));
                    fruitTransaction.setFruit(part[INDEX_FRUIT]);
                    fruitTransaction.setQuantity(Integer.parseInt(part[INDEX_QUANTITY]));
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperationByCode(String code) {
        for (FruitTransaction.Operation operation: FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown opcode" + code);
    }
}
