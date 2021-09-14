package core.basesyntax.service.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReaderImpl implements InputFileReader {
    @Override
    public List<String> readFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            String row;
            while ((row = reader.readLine()) != null) {
                result.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read input file, " + e);
        }
        return result;
    }
}
