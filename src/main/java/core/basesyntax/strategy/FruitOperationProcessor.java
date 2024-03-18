package core.basesyntax.strategy;

import core.basesyntax.model.FruitItem;
import core.basesyntax.model.Item_Operation;

public class FruitOperationProcessor {
    private static final int OPERATION_NEXT_INDEX = 3;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final int FRUIT_NAME_INDEX = 1;


    private final StrategyChooseFruit strategyChooser;

    public FruitOperationProcessor() {
        this.strategyChooser = new StrategyChooseFruit();
    }

    public void processOperations(String input) {
        String[] operations = input.split(",");
        for (int i = 0; i < operations.length; i += OPERATION_NEXT_INDEX) {
            String operationType = operations[i];
            String fruitName = operations[i + FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(operations[i + FRUIT_QUANTITY_INDEX]);

            FruitItem fruit = new FruitItem(fruitName, quantity);
            Item_Operation operation = Item_Operation.fromCode(operationType);

            FruitQuantityChange strategy = strategyChooser.getOptionFruitQuantityChange(operation);
            strategy.changeFruitQuantity(fruit);
        }
    }
}
