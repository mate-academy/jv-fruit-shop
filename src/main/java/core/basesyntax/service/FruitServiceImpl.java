package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final int REMOVE_NAMES_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<String[]> report(String data) {
        List<String[]> dataToWork = convertData(data);
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String[] transactionData : dataToWork) {
            FruitTransaction.Operation operation = FruitTransaction.Operation
                            .fromCode(transactionData[OPERATION_INDEX]);
            String fruit = transactionData[FRUIT_INDEX];
            int quantity = Integer.parseInt(transactionData[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }

        Map<String, Integer> fruitQuantities = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            int quantity = fruitQuantities.getOrDefault(transaction.getFruit(), 0);
            switch (transaction.getOperation()) {
                case BALANCE, SUPPLY, RETURN -> quantity += transaction.getQuantity();
                case PURCHASE -> quantity -= transaction.getQuantity();
                default -> throw new RuntimeException("No such operation");
            }
            fruitQuantities.put(transaction.getFruit(), quantity);
        }

        List<String[]> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : fruitQuantities.entrySet()) {
            result.add(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
        }
        result.add(0, new String[]{"fruit", "quantity"});

        return result;
    }

    private List<String[]> convertData(String data) {
        String[] splitBySeparator = data.split("\n");
        List<String[]> convert = new ArrayList<>();
        for (String s : splitBySeparator) {
            convert.add(s.split(","));
        }
        convert.remove(REMOVE_NAMES_INDEX);
        return convert;
    }
}
