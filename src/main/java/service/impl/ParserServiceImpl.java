package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String SPLIT_INDEX = ",";
    private static final int CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseLines(List<String> data) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] line = data.get(i).split(SPLIT_INDEX);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getByCode(line[CODE_INDEX]));
            fruitTransaction.setFruit(line[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(line[QUANTITY_INDEX]));
            fruits.add(fruitTransaction);
        }
        return fruits;
    }
}
