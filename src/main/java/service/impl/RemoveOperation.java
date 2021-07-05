package service.impl;

import db.Storage;
import model.Fruit;
import model.dto.FruitRecordDto;
import service.OperationHandler;

public class RemoveOperation implements OperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        if (Storage.fruits
                .getOrDefault(new Fruit(fruitRecordDto.getFruitName()),
                        0) < fruitRecordDto.getQuantity()) {
            throw new RuntimeException(fruitRecordDto.getFruitName() + " out of Stock!");
        }
        Fruit currentFruit = new Fruit(fruitRecordDto.getFruitName());
        int currentQuantityInStock = Storage.fruits.getOrDefault(currentFruit, 0);
        int newQuantityInStock = currentQuantityInStock - fruitRecordDto.getQuantity();
        Storage.fruits.put(currentFruit, newQuantityInStock);
        return newQuantityInStock;
    }
}
