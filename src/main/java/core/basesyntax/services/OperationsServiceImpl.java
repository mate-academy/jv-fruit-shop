package core.basesyntax.services;

import core.basesyntax.db.FruitDataBaseImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TypeOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsServiceImpl implements OperationsService {
    private static final String COMMA = ",";
    private static final int TITLE_INDEX = 0;
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;
    private static final int FRUIT_NAME_INDEX = 1;
    private final ValidatorServiceImpl validatorService = new ValidatorServiceImpl();

    @Override
    public Map<Fruit, Integer> countingActivities(FruitDataBaseImpl fruitDataBase) {
        String[] lineFromFile;
        List<String> stringList = fruitDataBase.getData();
        validatorService.inputDataValidator(stringList);
        validatorService.positiveQuantityValidator(stringList);
        stringList.remove(TITLE_INDEX);
        Map<Fruit, Integer> countingActivities = new HashMap<>();
        for (String line : stringList) {
            lineFromFile = line.split(COMMA);
            Integer quantity = new AccountingOperationsStrategyImpl().accountingOperations(
                    TypeOperation.getType(lineFromFile[TYPE_OPERATION_INDEX]),
                    Integer.parseInt(lineFromFile[QUANTITY_INDEX]));
            Fruit newFruit = new Fruit(lineFromFile[FRUIT_NAME_INDEX]);
            if (!countingActivities.containsKey(newFruit)) {
                countingActivities.put(newFruit, quantity);
            } else {
                Integer newQuantity = countingActivities.get(newFruit) + quantity;
                countingActivities.put(newFruit, newQuantity);
            }
        }
        validatorService.correctAmountValidator(countingActivities);
        return countingActivities;
    }
}
