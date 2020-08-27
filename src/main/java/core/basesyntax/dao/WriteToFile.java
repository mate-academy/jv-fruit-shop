package core.basesyntax.dao;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WriteToFile {
    public boolean writeToFile(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            createFile(filePath);
        } else {
            createFile(filePath);
        }

        Map<String, Integer> mapToFile = ListStorage.listStorage.stream()
                .collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.summingInt(Fruit::getAmount)));

        List<String> stringsToFile = new ArrayList<>();
        stringsToFile.add("fruit,quantity");

        for (Map.Entry<String, Integer> entry : mapToFile.entrySet()) {
            stringsToFile.add(entry.getKey() + "," + entry.getValue());
        }
        try {
            Files.write(path, stringsToFile, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Error with writing to file. "
                    + "Rerun main. ", e);
        }
        return true;
    }

    private void createFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
