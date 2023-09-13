package dao;

import database.Storage;
import model.Fruit;
import service.FruitService;
import service.impl.FruitServiceImpl;

public class FruitDaoImpl implements FruitDao {

    private FruitService fruitService;

    public FruitDaoImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    //private FruitService fruitService = new FruitServiceImpl();

    /*public FruitDaoImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }*/

    @Override
    public Fruit add(Fruit fruit) {
        Fruit newFruit = fruitService.createNewFruit(fruit.getName(), fruit.getQuantity());
        Storage.fruits.add(newFruit);
        return newFruit;
    }

    @Override
    public boolean check(Fruit fruit) {
        for (Fruit fruitFromStorage : Storage.fruits) {
            return fruitFromStorage.getName().equals(fruit.getName());
        }
        return false;
    }

    @Override
    public Fruit update(Fruit fruit) {
        for (Fruit fruitFromStorage : Storage.fruits) {
            if (fruitFromStorage.getName().equals(fruit.getName())) {
                fruitFromStorage.setQuantity(fruit.getQuantity());
                return fruitFromStorage;
            }
        } return null;
    }

    @Override
    public Fruit get(Fruit fruit) {
        for (Fruit fruitFromStorage : Storage.fruits) {
            if (fruitFromStorage.getName().equals(fruit.getName())) {
                return fruitFromStorage;
            }
        }
        return null;
    }

    @Override
    public Fruit increaseQuantity(Fruit fruit) {
        for (Fruit fruitFromStorage : Storage.fruits) {
            if (fruitFromStorage.getName().equals(fruit.getName())) {
                fruitFromStorage.setQuantity(fruitFromStorage.getQuantity()
                        + fruit.getQuantity());
                return fruitFromStorage;
            }
        }
        return null;
    }

    @Override
    public Fruit decreaseQuantity(Fruit fruit) {
        for (Fruit fruitFromStorage : Storage.fruits) {
            if (fruitFromStorage.getName().equals(fruit.getName())) {
                fruitFromStorage.setQuantity(fruitFromStorage.getQuantity()
                        - fruit.getQuantity());
                return fruitFromStorage;
            }
        }
        return null;
    }
}

