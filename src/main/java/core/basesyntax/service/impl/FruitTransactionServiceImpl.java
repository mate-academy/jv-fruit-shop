package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> castToList(List<String> fruitList) {
        try {
            fruitList.remove(0);

            return fruitList.stream()
                    .map(f -> castElementToFruitTransaction(f))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Can't parse the text", e);
        }
    }

    private FruitTransaction castElementToFruitTransaction(String element) {
        String[] elementArray = element.split(";");
        return new FruitTransaction(elementArray[OPERATION_INDEX],
                elementArray[FRUIT_NAME_INDEX],
                Integer.parseInt(elementArray[QUANTITY_INDEX]));
    }
}
