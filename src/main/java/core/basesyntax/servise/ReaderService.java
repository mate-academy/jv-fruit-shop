package core.basesyntax.servise;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface ReaderService {
    List<FruitRecordDto> readData();
}
