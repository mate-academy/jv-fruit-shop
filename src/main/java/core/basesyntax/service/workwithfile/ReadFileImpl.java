package core.basesyntax.service.workwithfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadFileImpl implements ReadFile {
    private final ParseFile parseFile = new ParseFile();

    @Override
    public List<String> readFromCsvFile(String filePath) {
        final File fruitFile = new File(parseFile.parseFileWithData());
        List<String> listOfFruits = new ArrayList<>();
        try {
            listOfFruits = Files.readAllLines(fruitFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fruitFile,e);
        }
        return listOfFruits;
    }
}
