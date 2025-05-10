package file.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {
    private static final String START_PATH = "./src/main/resources/";
    private static final String FILE_FORMAT = ".csv";

    @Override
    public List<String> readFromCsv(String fileName) {
        if (!fileName.endsWith(FILE_FORMAT)) {
            throw new RuntimeException("File " + fileName + " should be .csv");
        }

        List<String> readList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(START_PATH + fileName));
            while (scanner.hasNextLine()) {
                readList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }

        return readList;
    }
}
