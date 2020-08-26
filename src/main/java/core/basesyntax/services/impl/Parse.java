package core.basesyntax.services.impl;

import core.basesyntax.services.FruitParse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parse implements FruitParse {
    @Override
    public List<List<String>> readFile(String path) {
        List<List<String>> result = new ArrayList<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                List<String> oneLine = Arrays.asList(line.split(","));
                result.add(oneLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
