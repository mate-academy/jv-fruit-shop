package service;

import java.util.List;
import model.Fruit;

public interface ConvertData {
    List<Fruit> fruitList(List<String> inputInfo);
}
