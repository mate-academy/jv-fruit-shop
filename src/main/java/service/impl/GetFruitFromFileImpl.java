package service.impl;

import model.Fruit;
import service.GetFruitFromFile;

public class GetFruitFromFileImpl implements GetFruitFromFile {
    private final GetTypeFruitImpl getTypeFruitImpl = new GetTypeFruitImpl();

    @Override
    public Fruit getFruit(String line) {
        return new Fruit(getTypeFruitImpl.checkFruitType(line));
    }
}
