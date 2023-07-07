package core.shop.service.impl;

import core.shop.model.FruitTransaction;
import core.shop.model.OperationType;
import core.shop.service.ParseFruitTransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseFruitTransactionServiceImpl implements ParseFruitTransactionService {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMA_SPLITERATOR = ",";

    @Override
    public List<FruitTransaction> getFruitOperations(List<String> list) {
        List<String> withoutFirstLine = list.subList(1, list.size());
        return withoutFirstLine.stream()
                .map(fruit -> {
                    String[] splittedString = fruit.split(COMA_SPLITERATOR);
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperationType(OperationType.fromValue(
                            splittedString[ACTIVITY_TYPE_INDEX]));
                    fruitTransaction.setFruitName(splittedString[FRUIT_NAME_INDEX]);
                    fruitTransaction.setQuantity(Integer.parseInt(splittedString[QUANTITY_INDEX]));
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }

}
