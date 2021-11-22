package dao;

import java.util.List;
import model.Fruit;

public interface FruitDao {
    List<Fruit> getListRemainder();

    void setFruit(Fruit fruit);
}
