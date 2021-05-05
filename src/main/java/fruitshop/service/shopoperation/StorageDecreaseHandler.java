package fruitshop.service.shopoperation;

import fruitshop.dao.FruitStorageDao;
import fruitshop.exception.FruitQuantityException;
import fruitshop.model.dto.FruitOperationDto;
import java.math.BigDecimal;

public class StorageDecreaseHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public StorageDecreaseHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public FruitOperationDto apply(FruitOperationDto fruitOperationDto) {
        BigDecimal currentQuantity = fruitStorageDao.getValueFromStorage(fruitOperationDto);
        if (getVariationValue(fruitOperationDto).compareTo(currentQuantity) > 0) {
            throw new FruitQuantityException("Insufficient quantity of \""
                    + fruitOperationDto.getFruitName() + "\"");
        }
        FruitOperationDto newFruitOperationDto = new FruitOperationDto(
                fruitOperationDto.getOperationType(),
                fruitOperationDto.getFruitName(),
                currentQuantity.subtract(getVariationValue(fruitOperationDto)));
        fruitStorageDao.updateDataInStorage(newFruitOperationDto);
        return newFruitOperationDto;
    }
}
