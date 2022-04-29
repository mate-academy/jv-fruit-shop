package servise.convertobject;

import core.basesyntax.FruitTransaction;
import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToObjectImp implements ConvertToObject {
    private List<String> keys;
    private List<FruitTransaction> fruitTransactions = new ArrayList<>();

    @Override
    public List<String> convertToObject(List<String> input) {
        for (int i = 1; i < input.size(); i++) {
            String[] arrays = input.get(i).split(",");
            fruitTransactions.add(new FruitTransaction(arrays[0],
                    arrays[1], Integer.parseInt(arrays[2])));
        }
        keys = fruitTransactions.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .collect(Collectors.toList());
        for (int i = 0; i < keys.size(); i++) {
            Storage.MapDataBase.put(keys.get(i), listOperation(keys, i));
        }
        return keys;
    }

    private List<FruitTransaction> listOperation(List<String> keys, int i) {
        return fruitTransactions.stream()
                .filter(e -> e.getFruit().equals(keys.get(i)))
                .collect(Collectors.toList());
    }
}
