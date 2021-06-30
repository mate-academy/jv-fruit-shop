package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.dtos.FruitDtoTransaction;
import core.basesyntax.services.interfaces.DataValidator;
import core.basesyntax.services.interfaces.FruitDtoTransactionParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FruitDtoTransactionParserImpl implements FruitDtoTransactionParser {
    private static final String SPLIT_REGEX = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_TYPE_LENGTH = 1;

    @Override
    public List<FruitDtoTransaction> parse(List<String> lines) {
        List<FruitDtoTransaction> fruitDtoTransactions = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] record = line.split(SPLIT_REGEX);
            if (record[OPERATION_TYPE_INDEX].length() == OPERATION_TYPE_LENGTH) {
                Fruit fruit = new Fruit(record[FRUIT_NAME_INDEX]);
                int storageQuantity = Optional.ofNullable(Storage.getFruits().get(fruit)).orElse(0);
                int currentQuantity = Integer.parseInt(record[QUANTITY_INDEX]);
                DataValidator dataValidator = new DataValidatorImpl();
                dataValidator.checkIfQuantityPositive(currentQuantity);
                dataValidator.checkIfQuantitySufficiently(storageQuantity, currentQuantity);
                fruitDtoTransactions.add(new FruitDtoTransaction(
                        OperationType.getOperationType(record[OPERATION_TYPE_INDEX]),
                        fruit.getName(),
                        currentQuantity));
            }
        }
        return fruitDtoTransactions;
    }
}
