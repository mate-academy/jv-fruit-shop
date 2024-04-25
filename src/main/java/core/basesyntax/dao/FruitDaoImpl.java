package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.ChooseOperation;
import core.basesyntax.service.strategy.ChooseOperationImpl;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final String SEPARATOR = ",";

    @Override
    public Fruit getFruit(String line) {
        String[] splitLine = line.split(SEPARATOR);
        String fruitName = splitLine[ONE];
        for (int i = 0; i < Storage.FRUITS.size(); i++) {
            Fruit fruit = Storage.FRUITS.get(i);
            if (fruit.getName().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public void addFruit(String line) {
        String[] splitLine = line.split(SEPARATOR);
        String fruitName = splitLine[ONE];
        int fruitAmount = Integer.parseInt(splitLine[TWO]);
        Storage.FRUITS.add(new Fruit(fruitName, fruitAmount));
    }

    @Override
    public void updateAmount(String line) {
        ChooseOperation chooseOperation = new ChooseOperationImpl();
        getFruit(line).setAmount(chooseOperation.chooseOperation(line).doOperation(line));
    }

    @Override
    public List<Fruit> getFruitList() {
        return Storage.FRUITS;
    }
}
