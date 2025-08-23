package core.basesyntax.operationstorage.storage;

import core.basesyntax.filereader.FileReaderService;
import core.basesyntax.filereader.FileReaderServiceImpl;
import core.basesyntax.model.Operation;
import java.util.List;

public class Operations {
    public void storage() {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<Operation> listOfOperations = fileReaderService.readFromCsvFile();
    }
}
