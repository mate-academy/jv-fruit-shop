package core.basesyntax.serviceimpl;

import core.basesyntax.service.ConvertService;
import core.basesyntax.serviceimpl.FruitTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class ConvertServiceImpl implements ConvertService {
    @Override
    public List<FruitTransaction> convert(List<String> list) {
        final int typeIndex = 0;
        final int fruitIndex = 1;
        final int quantityIndex = 2;
        final List<FruitTransaction> transactionList = new ArrayList<>();
        for (String s : list) {
            String[] fruits = s.replaceAll("\\s+", "").split(",");
            String type = fruits[typeIndex];
            String fruit = fruits[fruitIndex];
            int quantity = Integer.parseInt(fruits[quantityIndex]);
            Operation operation = null;
            for (Operation operation1 : Operation.values()) {
                if (operation1.getCode().equals(type)) {
                    operation = operation1;
                }
            }
            transactionList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactionList;
    }

}
