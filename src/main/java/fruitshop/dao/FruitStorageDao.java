package fruitshop.dao;

import fruitshop.model.dto.FruitDto;
import fruitshop.model.dto.ReportDto;

public interface FruitStorageDao {
    Integer getValueFromStorage(FruitDto fruitDto);

    void updateDataInStorage(FruitDto fruitDto);

    ReportDto getDataFromStorage();
}
