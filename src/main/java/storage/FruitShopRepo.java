package storage;

import java.util.List;
import model.FruitDto;

public interface FruitShopRepo {
    List<FruitDto> getFruitsFromFile();

    void writeData(List<FruitDto> fruitDtoList);
}
