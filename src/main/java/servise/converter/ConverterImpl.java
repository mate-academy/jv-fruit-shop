package servise.converter;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;

public class ConverterImpl implements Converter {
    private static final String SPLITERATOR = ",";
    private static final int TYPE_OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convert(List<String> sourceData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < sourceData.size(); i++) {
            String[] arrays = sourceData.get(i).split(SPLITERATOR);
            fruitTransactions.add(new FruitTransaction(arrays[TYPE_OPERATION],
                    new Fruit(arrays[FRUIT_NAME]), Integer.parseInt(arrays[FRUIT_QUANTITY])));
        }
        return fruitTransactions;
    }
}
