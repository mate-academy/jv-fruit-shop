package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface FileReaderService {
    List<FruitDto> read(String filePath);
}
