package core.basesyntax.service.summaryofoperations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneralCalculation {
    private final StorageDao fruitList;

    public GeneralCalculation(StorageDao fruitList) {
        this.fruitList = fruitList;
    }

    public int getSumByOperationDependsOnFruit(Map<Operation,
            Map<String, List<Integer>>> fruitStore, Operation operation, String fruit) {
        int sum =
                fruitStore.entrySet().stream()
                        .filter(entry -> entry.getKey() == operation)
                        .map(Map.Entry::getValue)
                        .filter(innerMap -> innerMap.containsKey(fruit))
                        .map(innerMap -> innerMap.get(fruit))
                        .flatMap(List::stream)
                        .mapToInt(Integer::intValue).sum();
        if (sum >= 0) {
            return sum;
        } else {
            throw new RuntimeException("Amount of fruit " + fruit + ", in operation "
                    + operation + " less than 0");
        }
    }

    public List<String> calculateTotalAmount(Map<Operation, Map<String, List<Integer>>> storage) {
        List<String> listFruits = fruitList.getListOfFruits(storage);
        List<String> generalAmountList = new ArrayList<>();
        for (String typeOfFruit : listFruits) {
            int totalAmount = 0;
            totalAmount += getSumByOperationDependsOnFruit(storage,
                    Operation.BALANCE, typeOfFruit);
            totalAmount += getSumByOperationDependsOnFruit(storage,
                    Operation.SUPPLY, typeOfFruit);
            totalAmount += getSumByOperationDependsOnFruit(storage,
                    Operation.RETURN, typeOfFruit);
            totalAmount -= getSumByOperationDependsOnFruit(storage,
                    Operation.PURCHASE, typeOfFruit);
            generalAmountList.add(typeOfFruit + "," + totalAmount);
        }
        return generalAmountList;
    }
}
