package service.impl;

import db.Storage;
import model.Fruit;
import model.dto.FruitRecordDto;
import service.FruitOperationsService;

public class AddOperation implements FruitOperationsService {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit currentFruit = new Fruit(fruitRecordDto.getFruitName());
        int currentQuantityInStock = Storage.fruits.get(currentFruit);
        int newQuantityInStock = currentQuantityInStock + fruitRecordDto.getQuantity();
        Storage.fruits.put(currentFruit, newQuantityInStock);
        return newQuantityInStock;
    }
}
