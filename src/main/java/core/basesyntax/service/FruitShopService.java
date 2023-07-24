package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface FruitShopService {
    void saveData(List<FruitRecordDto> data);

    String getReport();
}
