package service.impl;

import db.Storage;
import model.Fruit;
import model.dto.FruitRecordDto;
import service.FruitOperationsService;

public class RemoveOperation implements FruitOperationsService {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        if (Storage.fruits
                .get(new Fruit(fruitRecordDto.getFruitName())) < fruitRecordDto.getQuantity()) {
            throw new RuntimeException(fruitRecordDto.getFruitName() + " out of Stock!");
        }
        fruitRecordDto.setQuantity(-fruitRecordDto.getQuantity());
        FruitOperationsService fruitOperationsService = new AddOperation();
        return fruitOperationsService.apply(fruitRecordDto);
    }
}
