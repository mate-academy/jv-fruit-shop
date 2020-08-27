package core.basesyntax.fileservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String[]> read(String filename) {
        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String line;
            int forRemoveHeader = 0;
            List<String[]> list = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                if (forRemoveHeader == 0) {
                    forRemoveHeader++;
                    continue;
                }
                String[] strings = line.split(",");
                list.add(strings);
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Problem with reading files", e);
        }
    }
}
