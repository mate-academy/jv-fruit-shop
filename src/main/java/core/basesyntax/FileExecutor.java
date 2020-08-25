package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FileExecutor {

    public List<String> readFile(String filePath) {
        validationInputFilePath(filePath);
        Path path = Paths.get(filePath);
        List<String> strings;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong!!!");
        }
        if (strings.size() == 0) {
            throw new NoSuchElementException("File is empty!!!");
        }
        strings.remove(0);
        return strings;
    }

    public List<String> createFruitStoreFile(List<Fruit> fruitStorage, String filePath) {
        validationInputFilePath(filePath);
        Path path = Paths.get(filePath);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return writeToFile(path, fruitStorage);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong!!!");
        }
    }

    private List<String> writeToFile(Path path, List<Fruit> fruitStorage) throws IOException {
        List<String> resultList = new ArrayList<>();
        String head = "fruit, quantity\n";
        Files.writeString(path, head);
        resultList.add(head);
        for (Fruit fruit : fruitStorage) {
            int sum = fruit.getStorage().values().stream().mapToInt(Integer::intValue).sum();
            String format = String.format("%s, %d\n", fruit.getName(), sum);
            resultList.add(format);
            Files.writeString(path, format, StandardOpenOption.APPEND);
        }
        return resultList;
    }

    private void validationInputFilePath(String filePath) {
        if (filePath.isEmpty()) {
            throw new IllegalArgumentException("Wrong filePath!!!");
        }
    }
}
