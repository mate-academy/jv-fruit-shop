package impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import model.Operation;
import service.ToFruitTransactionService;

public class ToFruitTransactionImpl implements ToFruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getListOfFruitTransactions(List<String> fileInfo) {
        return fileInfo.stream()
                .map(str -> str.split(","))
                .map(lineInfo -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(Operation
                            .getOperation(lineInfo[OPERATION_INDEX].trim()));
                    fruitTransaction.setFruit(lineInfo[FRUIT_INDEX]);
                    fruitTransaction.setQuantity(Integer.parseInt(lineInfo[QUANTITY_INDEX]));
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }
}
