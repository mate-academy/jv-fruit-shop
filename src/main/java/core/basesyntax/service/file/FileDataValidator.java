package core.basesyntax.service.file;

import core.basesyntax.model.ParsedLineFromFileCsv;
import java.util.List;

public interface FileDataValidator {
    void checkFileData(List<ParsedLineFromFileCsv> dataFromFile);
}
