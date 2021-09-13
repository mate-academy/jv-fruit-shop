package shop.service.operations;

import dao.FruitDaoImpl;
import shop.item.Fruit;

public class Balance implements Operation {
    @Override
    public void operation(Fruit fruit) {
        new FruitDaoImpl().add(fruit);
    }
}
