package core.basesyntax.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFileReaderImpl implements InputFileReader {
    @Override
    public Scanner readFromFile(String filePath) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the input file", e);
        }
        return scanner;
    }
}

