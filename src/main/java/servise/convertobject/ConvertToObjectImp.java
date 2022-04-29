package servise.convertobject;

import model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class ConvertToObjectImp implements ConvertToObject {
    @Override
    public List<FruitTransaction> convertToObject(List<String> input) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            String[] arrays = input.get(i).split(",");
            fruitTransactions.add(new FruitTransaction(arrays[0],
                    arrays[1], Integer.parseInt(arrays[2])));
        }
        return fruitTransactions;
    }
}
