package core.basesyntax.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileHandlerImpl implements InputFileHandler {
    private final List<String> inputList = new ArrayList<>();

    @Override
    public List<String> inputData(String filePath) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the path to file \"" + filePath + "\"", e);
        }
        while (scanner.hasNext()) {
            inputList.add(scanner.nextLine());
        }
        return inputList;
    }
}
