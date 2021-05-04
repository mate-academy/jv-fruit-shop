package service.impl;

import db.Storage;
import model.Fruit;
import model.dto.FruitRecordDto;
import service.FruitOperationsService;

public class RemoveOperations implements FruitOperationsService {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit currentFruit = new Fruit(fruitRecordDto.getFruitName());
        int currentQuantityInStock = Storage.fruits.get(currentFruit);
        if (currentQuantityInStock < fruitRecordDto.getQuantity()) {
            throw new RuntimeException("Out of Stock!");
        }
        int newQuantityInStock = currentQuantityInStock - fruitRecordDto.getQuantity();
        Storage.fruits.put(currentFruit, newQuantityInStock);
        return newQuantityInStock;
    }
}
