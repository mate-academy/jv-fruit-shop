package core.basesyntax.operations;

import core.basesyntax.interfaces.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> textFromFile = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                textFromFile.add(sc.nextLine().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Not correct file path.", e);
        }
        return textFromFile;
    }
}
