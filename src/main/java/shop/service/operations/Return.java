package shop.service.operations;

import dao.FruitDaoImpl;
import shop.item.Fruit;

public class Return implements Operation {
    @Override
    public void operation(Fruit fruit) {
        FruitDaoImpl dao = new FruitDaoImpl();
        fruit.setQuality(dao.get(fruit).getQuality() + fruit.getQuality());
        dao.update(fruit);
    }
}
