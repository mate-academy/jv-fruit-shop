package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReaderImpl implements FruitFileReader {
    @Override
    public List<String> read(Path path) {
        List<String> result = new ArrayList<>();
        File file = new File(String.valueOf(path));
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.readLine();
            String currentString;
            while ((currentString = bufferedReader.readLine()) != null) {
                result.add(currentString);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cant found file" + file.getName(), e);
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file" + file.getName(), e);
        }
        return result;
    }
}
