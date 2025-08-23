package core.basesyntax.filereader;

import core.basesyntax.model.Operation;
import java.util.List;

public interface FileReaderService {
    default List<Operation> readFromCsvFile() {

        return null;
    }

}
