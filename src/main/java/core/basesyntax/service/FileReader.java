package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import java.util.List;

public interface FileReader {
    List<FruitDto> readData(String fileName);
}
