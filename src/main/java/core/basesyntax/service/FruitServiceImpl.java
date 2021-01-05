package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.operation.Operation;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int AMOUNT = 2;

    @Override
    public void addNewFruit(List<String> allLines) {
        FruitDao fruitDao = new FruitDaoImpl();
        for (int i = 0; i < allLines.size(); i++) {
            String[] oneLineInfo = allLines.get(i).split(SPLITERATOR);
            if (oneLineInfo[OPERATION].toUpperCase().equals(Operation.Type.B.toString())) {
                fruitDao.add(new Fruit(oneLineInfo[FRUIT_NAME]),
                        Integer.parseInt(oneLineInfo[AMOUNT]));
            } else if (oneLineInfo[OPERATION].toUpperCase().equals(Operation.Type.S.toString())
                    && !fruitDao.containsKey(new Fruit(oneLineInfo[FRUIT_NAME]))) {
                fruitDao.add(new Fruit(oneLineInfo[FRUIT_NAME]),
                        Integer.parseInt(oneLineInfo[AMOUNT]));
                allLines.remove(i);
            }
        }
    }
}
