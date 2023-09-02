package core.basesyntax.serviceimpl;

import core.basesyntax.service.ConvertService;
import core.basesyntax.serviceimpl.FruitTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class ConvertServiceImpl implements ConvertService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(List<String> list) {

        final List<FruitTransaction> transactionList = new ArrayList<>();
        for (String s : list) {
            String[] fruits = s.replaceAll("\\s+", "").split(",");
            String type = fruits[TYPE_INDEX];
            String fruit = fruits[FRUIT_INDEX];
            int quantity = Integer.parseInt(fruits[QUANTITY_INDEX]);
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
