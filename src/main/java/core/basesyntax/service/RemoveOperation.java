package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.interfaces.FruitAvailabilityValidator;
import core.basesyntax.service.interfaces.FruitOperationHandler;
import java.util.Optional;

public class RemoveOperation implements FruitOperationHandler {
    private static final int DEFAULT_VALUE = 0;
    private static final String EXCEPTION_MESSAGE = "Amount of fruits you want "
            + "to buy is bigger than we currently have";
    private final FruitAvailabilityValidator fruitAvailabilityValidator;

    public RemoveOperation(FruitAvailabilityValidator fruitAvailabilityValidator) {
        this.fruitAvailabilityValidator = fruitAvailabilityValidator;
    }

    @Override
    public void applyAction(FruitRecordDto fruitRecordDto) {
        fruitAvailabilityValidator.checkAvailability(fruitRecordDto);
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        int currentQuantity = Storage.fruits.get(fruit);
        int subtractionResult = currentQuantity - fruitRecordDto.getQuantity();
        int newQuantity = currentQuantity < DEFAULT_VALUE ? Optional.of(subtractionResult)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE))
                : subtractionResult;
        Storage.fruits.put(fruit, newQuantity);
    }
}
