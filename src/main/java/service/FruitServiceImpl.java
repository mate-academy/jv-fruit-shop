package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;
    private final Map<String, FruitTransaction.Operation> operationConverterMap = Map.of(
            "b", FruitTransaction.Operation.BALANCE,
            "s", FruitTransaction.Operation.SUPPLY,
            "p", FruitTransaction.Operation.PURCHASE,
            "r", FruitTransaction.Operation.RETURN
    );

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processData(String dataFromCsv) {
        List<FruitTransaction> fruitTransactionsList =
                new TransactionMapper().stringToFruitTransaction(dataFromCsv);
        List<String> fruits = fruitTransactionsList.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .toList();

        List<Integer> quantityOfFruits = getListOfQuantity(fruits, fruitTransactionsList);

        Map<String, Integer> resultList = new HashMap<>();
        for (int i = 0; i < fruits.size(); i++) {
            resultList.merge(fruits.get(i), quantityOfFruits.get(i), Integer::sum);
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

    public class TransactionMapper {
        private static final String DATA_SEPARATOR = ",";
        private static final int OPERATION = 0;
        private static final int FRUIT = 1;
        private static final int QUANTITY = 2;

        public List<FruitTransaction> stringToFruitTransaction(String takenData) {
            return Arrays.stream(takenData.split(System.lineSeparator()))
                    .map(str -> {
                        String[] parts = str.split(DATA_SEPARATOR);
                        return new FruitTransaction(operationConverterMap.get(parts[OPERATION]),
                                parts[FRUIT],
                                Integer.valueOf(parts[QUANTITY]));
                    })
                    .collect(Collectors.toList());
        }
    }
}
