package core.basesyntax.service.readAndWriteToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String INPUT_FILEPATH =
            "src/main/resources/InputFile.csv";

    @Override
    public List<String> readFromFile() {
        List<String> transactions = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(INPUT_FILEPATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read from the file" + INPUT_FILEPATH, e);
        }
        while (scanner.hasNext()) {
            transactions.add(scanner.next());
        }
        return transactions;
    }
}
