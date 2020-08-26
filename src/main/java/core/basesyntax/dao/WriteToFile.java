package core.basesyntax.dao;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
//        Map<String, Integer> mapToFile = ListStorage.listStorage.stream()
//                .collect(Collectors.groupingBy(Fruit::getName),
//                        Collectors.summingInt(Fruit::getAmount));


//        for (Map.Entry<String, Integer> entry : mapToFile.entrySet()) {
//            String string = entry.getKey() + "," + entry.getValue();
//            try {
//                Files.write(path, Collections.singleton(string));
//            } catch (IOException e) {
//                System.out.println("Error with writing to file" + e.getMessage());
//            }
//        }
        StringBuilder builder = new StringBuilder();
        for (Fruit fruit : ListStorage.listStorage) {
            builder.append(fruit.getName()).append(",").append(fruit.getAmount()).append(System.lineSeparator());
        }
            byte[] arrToWrite = builder.toString().getBytes();
            try {
                Files.write(path, arrToWrite);
            } catch (IOException e) {
                System.out.println("Error with writing to file" + e.getMessage());
            }

    }
}
