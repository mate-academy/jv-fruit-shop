package core.basesyntax.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderService {

    public List<String> readLinesFromFile(String fileName) {
        try {
            String[] inputFileAsStrings = Files.readString(Paths.get(fileName)).split("\n");
            return new ArrayList<>(Arrays.asList(inputFileAsStrings));
        } catch (IOException e) {
            throw new RuntimeException("Got problem with reading of file [" + fileName + "]");
        }
    }
}
