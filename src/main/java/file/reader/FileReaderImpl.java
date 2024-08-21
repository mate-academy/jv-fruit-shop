package file.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {
    private static final String START_PATH = "./";

    @Override
    public List<String> read(String fileName) {
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
