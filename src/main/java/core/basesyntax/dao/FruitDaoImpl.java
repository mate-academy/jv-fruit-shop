package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.operation.ChooseOperation;
import core.basesyntax.service.operation.ChooseOperationImpl;
import java.util.List;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Fruit getFruit(String line) {
        String fruitName = line.split(",")[1];
        for (int i = 0; i < Storage.FRUITS.size(); i++) {
            if (Storage.FRUITS.get(i).getName().equals(fruitName)) {
                return Storage.FRUITS.get(i);
            }
        }
        return null;
    }

    @Override
    public void addFruit(String line) {
        String fruitName = line.split(",")[1];
        int fruitAmount = Integer.parseInt(line.split(",")[2]);
        Storage.FRUITS.add(new Fruit(fruitName, fruitAmount));
    }

    @Override
    public void upDateAMount(String line) {
        ChooseOperation chooseOperation = new ChooseOperationImpl();
        getFruit(line).setAmount(chooseOperation.chooseOperation(line).doOperation(line));
    }

    @Override
    public List<Fruit> getFruitList() {
        return Storage.FRUITS;
    }
}
