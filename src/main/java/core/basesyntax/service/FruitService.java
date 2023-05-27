package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface FruitService {
    String makeReport();

    void saveData(List<FruitRecordDto> listParse);
}
