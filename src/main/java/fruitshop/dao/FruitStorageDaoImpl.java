package fruitshop.dao;

import fruitshop.db.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.dto.FruitDto;
import fruitshop.model.dto.ReportDto;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public Integer getValueFromStorage(FruitDto fruitDto) {
        Fruit fruit = new Fruit(fruitDto.getFruitName());
        if (FruitStorage.getFruitMap().containsKey(fruit)) {
            return FruitStorage.getFruitMap().get(fruit);
        }
        return 0;
    }

    @Override
    public void updateDataInStorage(FruitDto fruitDto) {
        FruitStorage.getFruitMap()
                .put(new Fruit(fruitDto.getFruitName()), fruitDto.getQuantity());
    }

    @Override
    public ReportDto getDataFromStorage() {
        return new ReportDto(FruitStorage.getFruitMap().entrySet());
    }
}
