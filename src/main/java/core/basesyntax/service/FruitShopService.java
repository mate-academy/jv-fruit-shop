package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface FruitShopService {
    String createReport();

    void save(List<FruitRecordDto> fruitRecordDtos);
}
