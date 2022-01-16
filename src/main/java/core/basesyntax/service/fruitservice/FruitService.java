package core.basesyntax.service.fruitservice;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface FruitService {
    void saveData(List<FruitRecordDto> fruitRecordDto);

    String createReport();
}
