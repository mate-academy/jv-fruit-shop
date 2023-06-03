package fruitshop.service.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.service.ParseTextService;
import java.util.ArrayList;
import java.util.List;

public class ParseTextServiceImpl implements ParseTextService {
    private static final String COMMA_SEPARATOR = ",";
    private static final int TYPE_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int DEFAULT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private List<FruitTransaction> fruitTransactions;

    @Override
    public List<FruitTransaction> parseReport(List<String> stringList) {
        fruitTransactions = new ArrayList<>();
        for (int i = DEFAULT_POSITION; i < stringList.size(); i++) {
            String[] parse = stringList.get(i).split(COMMA_SEPARATOR);
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.getByCode(parse[TYPE_POSITION]);
            String fruit = parse[FRUIT_POSITION];
            int quantity = Integer.parseInt(parse[QUANTITY_POSITION]);
            fruitTransactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactions;
    }
}
