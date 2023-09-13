package dao;

import database.Storage;
import exception.InvalidDataException;
import model.Fruit;
import service.FruitService;

public class FruitDaoImpl implements FruitDao {

    private FruitService fruitService;

    public FruitDaoImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public Fruit add(Fruit fruit) {
        Fruit newFruit = fruitService.createNewFruit(fruit.getName(), fruit.getQuantity());
        Storage.fruits.add(newFruit);
        return newFruit;
    }

    @Override
    public Fruit get(Fruit fruit) {
        for (Fruit fruitFromStorage : Storage.fruits) {
            if (fruitFromStorage.getName().equals(fruit.getName())) {
                return fruitFromStorage;
            }
        }
        throw new InvalidDataException("There is no fruit with name: " + fruit.getName());
    }
}

