package core.basesyntax.dao;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.TreeMapStorage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WriteToFile {
    public void writeToFile(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.out.println("File " + path.getFileName() + " is not deleted" + e.getMessage());
            }
        } else {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("File " + path.getFileName() + " is not created" + e.getMessage());
            }
        }

        Map<String, Integer> hashMapToFile = new HashMap<>();
        for (Map.Entry<LocalDate, Fruit> entry : TreeMapStorage.treeMapStorage.entrySet()) {
            String productName = entry.getValue().getName();
            if (hashMapToFile.containsKey(productName)) {
                hashMapToFile.put(productName,
                        hashMapToFile.get(productName) + entry.getValue().getAmount());
                continue;
            }
            hashMapToFile.put(productName, entry.getValue().getAmount());
        }
        for (Map.Entry<String, Integer> entry : hashMapToFile.entrySet()) {
            String string = entry.getKey() + "," + entry.getValue();
            try {
                Files.write(path, Collections.singleton(string));
            } catch (IOException e) {
                System.out.println("Error with writing to file" + e.getMessage());
            }
        }
    }
}
