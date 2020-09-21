package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {
    public List<String> readFile(String filePath) {
        List<String> orders = new ArrayList<>();
        String line;
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (!((line = br.readLine()) == null)) {
                if (line.contains("type,fruit,quantity,date")) {
                    continue;
                }
                List<String> singleLine = Arrays.asList(line.split(","));
                if (singleLine.size() == 4) {
                    orders.add(line);
                } else {
                    throw new RuntimeException("Incorrect format");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("This file does not exist!", e);
        }
        if (file.length() == 0) {
            throw new RuntimeException("Your file is empty!");
        }
        return orders;
    }

    public void writeToFile(String report, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("No Such Destination!");
        }
    }
}
