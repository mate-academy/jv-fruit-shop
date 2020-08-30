package core.basesyntax.services.impl;

import core.basesyntax.services.FruitParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser implements FruitParser {
    @Override
    public List<List<String>> readFile(String path) {
        List<List<String>> result = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                line = line.toLowerCase();
                String[] splitetLine = line.split(",");
                if (splitetLine.length == 4) {
                    List<String> oneLine = Arrays.asList(splitetLine);
                    result.add(oneLine);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File read error" + path, e);
        }
        return result;
    }
}
