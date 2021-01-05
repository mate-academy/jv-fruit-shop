package core.basesyntax.service.implementations;

import core.basesyntax.service.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader implements FileReader {
    @Override
    public List<String> getAllLines(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(Path.of(path)))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                list.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR: File is missing " + e);
        }
        return list;
    }
}
