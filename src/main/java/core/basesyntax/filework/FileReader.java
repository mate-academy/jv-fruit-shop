package core.basesyntax.filework;

import core.basesyntax.dao.FruitRecordDto;
import java.util.List;

public interface FileReader {
    void read(String pathToFile);

    List<FruitRecordDto> getStorage();
}
