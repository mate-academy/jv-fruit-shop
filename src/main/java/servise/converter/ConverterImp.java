package servise.converter;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;

public class ConverterImp implements Converter {
    @Override
    public List<FruitTransaction> convert(List<String> input) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            String[] arrays = input.get(i).split(",");
            fruitTransactions.add(new FruitTransaction(arrays[0],
                    new Fruit(arrays[1]), Integer.parseInt(arrays[2])));
        }
        return fruitTransactions;
    }
}
