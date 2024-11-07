package core.basesyntax.dao;

import core.basesyntax.model.Account;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class fileReaderImpl implements fileReader {

    @Override
    public String[] read(String nameOfFile) {
       List<String> textInFile = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(nameOfFile))) {
            textInFile = Files.readAllLines(Path.of(nameOfFile));
            return textInFile.stream()
                    .filter(i -> i.startsWith("b") || i.startsWith("s")
                    || i.startsWith("p") || i.startsWith("r"))
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the data from the file " + nameOfFile, e);
        }
    }
}
