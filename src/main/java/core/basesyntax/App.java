package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.impl.FileReaderServiceImpl;

import java.util.List;

public class App {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_file.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output_file.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readAllLines(INPUT_FILE_PATH);
    }
}
