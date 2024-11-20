package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadDatafile {

    private static final String INPUT_FILE_NAME = "InputFile.csv";

    public Map<String, Integer> getInputDataFromFile() {

        List<String> inputReadedFile = new ArrayList<>();

        try {
            inputReadedFile = Files.readAllLines(Path.of(INPUT_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read that file!", e);
        }

        Map<String, Integer> fruitQuantity = new HashMap<>();

        for (String currentLine : inputReadedFile) {

            if (currentLine.startsWith("type,")) {
                continue;
            }

            String[] fields = currentLine.split(",");

            if (fields.length != 3) {
                continue;
            }

            String type = fields[0];
            String fruit = fields[1];
            int quantity;

            try {
                quantity = Integer.parseInt(fields[2]);
            } catch (NumberFormatException e) {
                continue;
            }

            fruitQuantity.putIfAbsent(fruit, 0);
            switch (type) {
                case "b" -> fruitQuantity.put(fruit, quantity);
                case "s", "r" -> fruitQuantity.put(fruit, fruitQuantity.get(fruit) + quantity);
                case "p" -> fruitQuantity.put(fruit, fruitQuantity.get(fruit) - quantity);
                default -> {
                }
            }
        }

        return fruitQuantity;
    }
}
