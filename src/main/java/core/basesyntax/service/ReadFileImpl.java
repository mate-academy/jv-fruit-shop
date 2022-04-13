package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileImpl implements ReadFile {
    @Override
    public List<String> readFileToList(String filePath) {
        List<String> result = new ArrayList<>();
        String readLine;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((readLine = reader.readLine()) != null) {
                result.add(readLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(" Can`t open file " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException(" Can`t read file" + filePath, e);
        }
        return result;
    }
}
