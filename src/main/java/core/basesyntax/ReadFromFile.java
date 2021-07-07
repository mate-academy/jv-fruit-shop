package core.basesyntax;

import core.basesyntax.interfaces.ReadFromTheFileInterface;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile implements ReadFromTheFileInterface {

    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> textFromFile = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                textFromFile.add(sc.nextLine().toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open file ", e);
        }
        return textFromFile;
    }
}
