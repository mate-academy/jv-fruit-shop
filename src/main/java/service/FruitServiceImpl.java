package service;

import model.Fruit;

public class FruitServiceImpl implements FruitService {
    @Override
    public Fruit createFruit(String name) {
        return new Fruit(name);
    }
}
