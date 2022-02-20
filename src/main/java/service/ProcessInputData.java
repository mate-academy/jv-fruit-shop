package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitModel;
import strategy.Strategy;
import strategy.StrategyImpl;
import strategy.handlers.Balance;
import strategy.handlers.Purchase;
import strategy.handlers.Return;
import strategy.handlers.Supply;

public class ProcessInputData {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final Map<String, Strategy> operationsWithFruits;

    public ProcessInputData() {
        operationsWithFruits = new HashMap<>();
        operationsWithFruits.put("b", new Balance());
        operationsWithFruits.put("s", new Supply());
        operationsWithFruits.put("r", new Return());
        operationsWithFruits.put("p", new Purchase());
    }

    private FruitModel getFruitModel(String[] line) {
        FruitModel fruitModel = new FruitModel();
        fruitModel.setName(line[NAME_INDEX]);
        fruitModel.setAmount(Integer.valueOf(line[AMOUNT_INDEX]));
        return fruitModel;
    }

    private void executeOperation(String[] line) {
        FruitModel fruitModel = getFruitModel(line);
        StrategyImpl strategyImpl = new StrategyImpl(operationsWithFruits
                .get(line[OPERATION_INDEX]));
        strategyImpl.executeStrategy(fruitModel);
    }

    public void processInput(List<String[]> parsedData) {
        for (String[] operation: parsedData) {
            executeOperation(operation);
        }
    }
}
