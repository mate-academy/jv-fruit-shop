package fruitshop.dao;

import fruitshop.db.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.dto.FruitOperationDto;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public BigDecimal getValueFromStorage(FruitOperationDto fruitOperationDto) {
        Fruit fruit = new Fruit(fruitOperationDto.getFruitName());
        if (FruitStorage.getFruitMap().containsKey(fruit)) {
            return FruitStorage.getFruitMap().get(fruit);
        }
        return BigDecimal.valueOf(0);
    }

    @Override
    public void updateDataInStorage(FruitOperationDto fruitOperationDto) {
        FruitStorage.getFruitMap()
                .put(new Fruit(fruitOperationDto.getFruitName()), fruitOperationDto.getQuantity());
    }

    @Override
    public Set<Map.Entry<Fruit, BigDecimal>> getDataReportFromStorage() {
        return FruitStorage.getFruitMap().entrySet();
    }
}
