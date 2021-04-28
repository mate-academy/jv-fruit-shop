package fruitshop.service.operation;

import fruitshop.dao.FruitStorageDao;
import fruitshop.model.dto.FruitDto;

public class StorageDecreaseHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public StorageDecreaseHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public FruitDto apply(FruitDto fruitDto) {
        Integer currentQuantity = fruitStorageDao.getValueFromStorage(fruitDto);
        Integer decrement = fruitDto.getQuantity();
        if (decrement < 0) {
            throw new RuntimeException("Fruits quantity cannot be negative");
        }
        if (decrement > currentQuantity) {
            throw new RuntimeException("Insufficient quantity of " + fruitDto.getFruitName());
        }

        FruitDto newFruitDto = new FruitDto(fruitDto.getOperationType(),
                fruitDto.getFruitName(),
                currentQuantity - decrement);
        fruitStorageDao.updateDataInStorage(newFruitDto);
        return newFruitDto;
    }
}
