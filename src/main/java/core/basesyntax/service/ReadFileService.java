package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import java.io.IOException;
import java.util.List;

public interface ReadFileService {
    List<FruitDto> readFile(String path) throws IOException;
}
