package service.action.type;

import dao.FruitDaoImpl;
import java.util.List;
import model.Fruit;

public class ActionMinusCountHandler extends ActionStrategyHandler {
    private final FruitDaoImpl reportLocalDao = new FruitDaoImpl();

    @Override
    public void doing(String[] data) {
        List<Fruit> fruits = reportLocalDao.getListRemainder();
        for (Fruit fruit1 : fruits) {
            if (fruit1.getName().equals(data[1])) {
                if (fruit1.getCount() < Integer.parseInt(data[2])) {
                    throw new RuntimeException("the quantity of goods cannot be negative");
                }
                fruit1.setCount(fruit1.getCount() - Integer.parseInt(data[2]));

                return;
            }
        }
        Fruit fruit = new Fruit(data[1], Integer.parseInt(data[2]));
        reportLocalDao.setFruit(fruit);
    }
}
