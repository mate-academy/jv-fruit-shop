package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {
    public static final String INPUT_FILE_NAME = "src/main/resources/fruits.csv";
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> readFromFileToArray() {
        List<String[]> strings;
        try {
            strings = Files.readAllLines(Path.of(INPUT_FILE_NAME))
                    .stream()
                    .map(words -> words.split(DELIMITER))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + INPUT_FILE_NAME);
        }
        List<FruitTransaction> listOfFruitTrsacion = new ArrayList<>();

        for (String[] el : strings) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            for (int i = 0; i < el.length; i += 3) {
                fruitTransaction.setOperation(el[i]);
                fruitTransaction.setFruit(el[i + 1]);
                fruitTransaction.setQuantity(Integer.parseInt(el[i + 2]));

            }
            listOfFruitTrsacion.add(fruitTransaction);

        }
        return listOfFruitTrsacion;
    }
}
