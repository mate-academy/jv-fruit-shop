package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.impl.FileReaderServiceImpl;

import java.util.List;

public class MainFruitShop {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> data = fileReaderService.readFromFile(INPUT_DATA_FILE);
        data.stream().forEach(System.out::println);




    }

    private static final String INPUT_DATA_FILE = "src/main/resources/input_data.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/output_data.csv";
}
