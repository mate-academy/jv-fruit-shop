package core.basesyntax.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileHandlerImpl implements InputFileHandler {
    private final List<String> inputList = new ArrayList<>();

    @Override
    public List<String> inputData(Scanner scanner) {
        while (scanner.hasNext()) {
            inputList.add(scanner.nextLine());
        }
        return inputList;
    }
}
