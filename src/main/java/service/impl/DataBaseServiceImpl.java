package service.impl;

import db.Storage;
import model.Fruit;
import service.DataBaseService;

public class DataBaseServiceImpl implements DataBaseService {
    @Override
    public int read(Fruit fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public void write(Fruit fruit, Integer newQuantityInStock) {
        Storage.fruits.put(fruit, newQuantityInStock);
    }
}
