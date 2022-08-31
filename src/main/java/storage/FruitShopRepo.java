package storage;

import java.io.File;
import java.util.List;
import model.FruitDto;

public interface FruitShopRepo {
    List<FruitDto> getFruitsFromFile(File file);

    File writeData(List<FruitDto> fruitDtoList);
}
