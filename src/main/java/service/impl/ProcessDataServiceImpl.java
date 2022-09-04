package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;
import service.ProcessDataService;

public class ProcessDataServiceImpl implements ProcessDataService {

    @Override
    public List<FruitTransaction> processData(List<String> list) {

        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        list.remove(0);
        for (String fruit : list) {
            String[] splitString = fruit.split(",");
            fruitTransactions.add(new FruitTransaction(splitString[0],
                            new Fruit(splitString[1]), Integer.parseInt(splitString[2])));

        }
        return fruitTransactions;
    }
}
