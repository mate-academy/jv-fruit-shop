package core.basesyntax.service.file;

import core.basesyntax.model.ParsedCsvLine;
import java.util.List;

public interface Validator {
    void checkFileData(List<ParsedCsvLine> dataFromFile);
}
