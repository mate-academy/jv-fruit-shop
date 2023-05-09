package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarehouseDaoWrite {
    public static final String BEGIN_OF_CSV = "fruit,quantity";

    public static void writeData(String fileName, Map<String, Integer> remains) {
        List<String> outputList = remains.entrySet().stream().map(
                entry -> entry.getKey() + "," + entry.getValue()).collect(Collectors.toList());
        Path filePath = Paths.get(fileName);
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't overwrite a file " + filePath, e);
        }
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file " + filePath, e);
        }
        try {
            Files.writeString(filePath, BEGIN_OF_CSV
                        + System.lineSeparator(), StandardOpenOption.APPEND);
            for (String str : outputList) {
                Files.writeString(filePath, str
                        + System.lineSeparator(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't add line to file " + filePath, e);
        }

    }
}
