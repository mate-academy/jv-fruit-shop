package core.basesyntax.service.impl;

import core.basesyntax.exception.NoSuchOperationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FruitTransactionParserServiceImpl implements DataParserService {
    private static final String SEPARATED_VALUE = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_COUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruitInfo) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < fruitInfo.size(); i++) {
            String[] parsedLine = fruitInfo.get(i).split(SEPARATED_VALUE);
            FruitTransaction fruit = new FruitTransaction();
            fruit.setOperation(getOperationByStringValue(parsedLine[OPERATION_INDEX]));
            fruit.setFruit(new Fruit(parsedLine[FRUIT_NAME_INDEX]));
            fruit.setQuantity(Integer.parseInt(parsedLine[FRUIT_COUNT_INDEX]));
            fruitTransactions.add(fruit);
        }
        return fruitTransactions;
    }

    private FruitTransaction.Operation getOperationByStringValue(String value) {
        Optional<FruitTransaction.Operation> operation =
                Arrays.stream(FruitTransaction.Operation.values())
                        .filter(x -> x.getOperation().equals(value))
                        .findFirst();
        return operation.orElseThrow(
                () -> new NoSuchOperationException("Can't found operation by this value" + value));
    }
}
