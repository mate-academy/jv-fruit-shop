package core.basesyntax.filereader;

import core.basesyntax.kindoffruitsstorage.KindOfFruitsStack;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {

    private static final String NAME_OF_FILE = "DataBase.csv";

    @Override
    public List<Operation> readFromCsvFile() {
        List<String> operations = new ArrayList<>();
        try {
            operations = Files.readAllLines(Path.of(NAME_OF_FILE));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return operations.stream()
                .map(this::transformLineToOperation)
                .collect(Collectors.toList());
    }

    private Operation transformLineToOperation(String line) {
        String[] elements = line.split(",");
        Operation operationFromDataBase = new Operation();
        operationFromDataBase.setTypeOfOperation(TypeOfOperation.valueOf(elements[0]));
        operationFromDataBase.setFruit(elements[1]);
        operationFromDataBase.setQuantity(Integer.parseInt(elements[2]));

        if (!KindOfFruitsStack.kindOfFruits.contains(elements[1])) {
            KindOfFruitsStack.kindOfFruits.add(elements[1]);
        }
        return operationFromDataBase;
    }
}
