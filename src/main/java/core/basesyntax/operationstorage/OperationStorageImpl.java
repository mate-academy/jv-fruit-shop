package core.basesyntax.operationstorage;

import core.basesyntax.filereader.FileReaderService;
import core.basesyntax.filereader.FileReaderServiceImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import java.util.List;
import java.util.stream.Collectors;

public class OperationStorageImpl implements OperationStorageService {
    private FileReaderService fileReaderService = new FileReaderServiceImpl();

    @Override
    public List<Operation> getOperationsByTypeAndFruit(TypeOfOperation typeOfOperation,
                                                       String fruit) {
        List<Operation> operations = fileReaderService.readFromCsvFile();
        return operations.stream()
                    .filter(o -> o.getTypeOfOperation().equals(typeOfOperation))
                    .filter(o -> o.getFruit().equals(fruit))
                    .collect(Collectors.toList());
    }
}
