package fruitshop.service.operation;

import fruitshop.dao.FruitStorageDao;
import fruitshop.model.dto.FruitDto;

public class StorageIncreaseHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public StorageIncreaseHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public FruitDto apply(FruitDto fruitDto) {
        Integer currentQuantity = fruitStorageDao.getValueFromStorage(fruitDto);
        Integer increment = fruitDto.getQuantity();
        FruitDto newFruitDto = new FruitDto(fruitDto.getOperationType(),
                fruitDto.getFruitName(),
                currentQuantity + increment);
        fruitStorageDao.updateDataInStorage(newFruitDto);
        return newFruitDto;
    }
}
