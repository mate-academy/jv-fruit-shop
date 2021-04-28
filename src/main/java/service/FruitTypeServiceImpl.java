package service;

import exception.InvalidFruitTypeException;
import model.Fruit;
import service.interfaces.FruitTypeService;

public class FruitTypeServiceImpl implements FruitTypeService {
    private static final String MESSAGE_FOR_EXCEPTION = "Incorrect Type of Fruit";

    @Override
    public Fruit.Type getFruitType(String type) {
        switch (type) {
            case "apple":
                return Fruit.Type.APPLE;
            case "banana":
                return Fruit.Type.BANANA;
            default:
                throw new InvalidFruitTypeException(MESSAGE_FOR_EXCEPTION);
        }
    }
}
