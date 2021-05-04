package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface FruitService {
    boolean saveDataToDataBase(List<FruitRecordDto> fruitRecordDtos);
}
