package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processData(List<FruitTransaction> dataFromCsv) {
        List<String> fruits = dataFromCsv.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .toList();

        List<Integer> quantityOfFruits = getListOfQuantity(fruits, dataFromCsv);

        Map<String, Integer> resultList = new HashMap<>();
        for (int i = 0; i < fruits.size(); i++) {
            resultList.put(fruits.get(i), quantityOfFruits.get(i));
        }

        return resultList;
    }

    private List<Integer> getListOfQuantity(List<String> fruits,
                                            List<FruitTransaction> dataFromCsv) {
        Map<String, Integer> resultList = new HashMap<>();
        for (String fruit : fruits) {
            resultList.put(fruit, 0);
        }

        List<Integer> quantityOfFruits = new ArrayList<>();

        for (String fruit : fruits) {
            int wholeQuantity = 0;
            int quantity = 0;
            for (FruitTransaction line : dataFromCsv) {
                if (fruit.equals(line.getFruit())) {
                    quantity = operationStrategy.get(line.getOperation())
                            .executionOfOperation(line.getQuantity(), wholeQuantity);

                    wholeQuantity = quantity;
                }
            }
            quantityOfFruits.add(quantity);
        }
        return quantityOfFruits;
    }
}
