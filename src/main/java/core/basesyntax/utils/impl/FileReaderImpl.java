package core.basesyntax.utils.impl;

import core.basesyntax.utils.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("There is not such file as " + filePath);
        }
        if (!file.getName().endsWith(".csv")) {
            throw new RuntimeException("This is not CSV file!");
        }
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot find the file " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read " + file.getAbsolutePath());
        }
        return result;
    }

}
