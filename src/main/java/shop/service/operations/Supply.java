package shop.service.operations;

import dao.FruitDaoImpl;
import shop.item.Fruit;

public class Supply implements Operation {
    @Override
    public void operation(Fruit fruit) {
        FruitDaoImpl dao = new FruitDaoImpl();
        if (dao.get(fruit) != null) {
            fruit.setQuality(fruit.getQuality() + dao.get(fruit).getQuality());
            dao.update(fruit);
        } else {
            new FruitDaoImpl().add(fruit);
        }
    }
}
