package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface ReaderService {
    List<FruitRecordDto> read(String path);
}
