package service;

import exception.InvalidFruitTypeException;
import model.Fruit;
import service.interfaces.GetFruitTypeService;

public class GetFruitTypeServiceImpl implements GetFruitTypeService {

    @Override
    public Fruit.Type getFruitType(String type) {
        switch (type) {
            case "apple":
                return Fruit.Type.APPLE;
            case "banana":
                return Fruit.Type.BANANA;
            default:
                throw new InvalidFruitTypeException("Incorrect Type of Fruit");
        }
    }
}
