package fruitshop.service.shopoperation;

import fruitshop.dao.FruitStorageDao;
import fruitshop.model.dto.FruitOperationDto;
import java.math.BigDecimal;

public class StorageIncreaseHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public StorageIncreaseHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public FruitOperationDto apply(FruitOperationDto fruitOperationDto) {
        BigDecimal currentQuantity = fruitStorageDao.getValueFromStorage(fruitOperationDto);
        FruitOperationDto newFruitOperationDto = new FruitOperationDto(
                fruitOperationDto.getOperationType(),
                fruitOperationDto.getFruitName(),
                currentQuantity.add(getVariationValue(fruitOperationDto)));
        fruitStorageDao.updateDataInStorage(newFruitOperationDto);
        return newFruitOperationDto;
    }
}
