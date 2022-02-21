package core.basesyntax.service.file;

import core.basesyntax.model.CsvLineDto;
import java.util.List;

public interface Validator {
    void checkFileData(List<CsvLineDto> dataFromFile);
}
