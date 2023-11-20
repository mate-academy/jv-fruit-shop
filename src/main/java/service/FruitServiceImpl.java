package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class FruitServiceImpl implements FruitService {
    private OperationStrategyImpl operationStrategy;

    public FruitServiceImpl(OperationStrategyImpl operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processData(List<FruitTransaction> dataFromCsv) {
        List<String> fruits = dataFromCsv.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .toList();

        int[] quantityOfFruits = getListOfQuantity(fruits, dataFromCsv);

        Map<String, Integer> resultList = new HashMap<>();
        int counter = 0;
        for (String fruit : fruits) {
            resultList.put(fruit, quantityOfFruits[counter]);
        }

        return resultList;
    }

    private int[] getListOfQuantity(List<String> fruits, List<FruitTransaction> dataFromCsv) {
        Map<String, Integer> resultList = new HashMap<>();
        for (String fruit : fruits) {
            resultList.put(fruit, 0);
        }

        int[] quantityOfFruits = new int[resultList.size()];
        int counter = 0;

        for (String fruit : fruits) {
            int wholeQuantity = 0;

            for (FruitTransaction line : dataFromCsv) {
                if (fruit.equals(line.getFruit())) {
                    quantityOfFruits[counter] = operationStrategy.get(line.getOperation())
                            .executionOfOperation(line.getQuantity(), wholeQuantity);

                    wholeQuantity = quantityOfFruits[counter];
                }
            }
            counter++;
        }
        return quantityOfFruits;
    }
}
