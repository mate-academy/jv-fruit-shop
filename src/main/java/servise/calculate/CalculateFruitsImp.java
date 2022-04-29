package servise.calculate;

import core.basesyntax.FruitTransaction;
import db.Storage;
import java.util.List;
import java.util.Map;

public class CalculateFruitsImp implements CalculateFruits {
    @Override
    public Map<String, List<FruitTransaction>> calculateFruits(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            List<FruitTransaction> fruitTransactionList = Storage.MapDataBase.get(list.get(i));
            int counter = fruitTransactionList.get(0).getQuantity();
            for (int j = 1; j < fruitTransactionList.size(); j++) {
                if (fruitTransactionList.get(j).getOperation().equals("p")) {
                    counter -= fruitTransactionList.get(j).getQuantity();
                    continue;
                }
                counter += fruitTransactionList.get(j).getQuantity();
            }
            FruitTransaction result = new FruitTransaction();
            result.setFruit(fruitTransactionList.get(i).getFruit());
            result.setQuantity(counter);
            Storage.MapDataBaseReport.put(result.getFruit(),result.getQuantity());
        }
        return Storage.MapDataBase;
    }
}
