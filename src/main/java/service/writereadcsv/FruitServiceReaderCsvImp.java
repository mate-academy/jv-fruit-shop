package service.writereadcsv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import model.Fruit;

public class FruitServiceReaderCsvImp implements FruitServiceReaderCsv {
    private final String fileName = "src/main/java/db/fruit.csv";
    private final String skipTitleFile = Pattern.compile("(\\w+,){2}\\d+").pattern();
    private final int typeFruitOperation = 0;
    private final int nameFruit = 1;
    private final int quantityFruit = 2;
    private List<String> fruitsList;

    public FruitServiceReaderCsvImp() {
        try {
            fruitsList = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
    }

    @Override
    public List<Fruit> read(String fruitName) {
        return fruitsList.stream()
                .filter(line -> line.contains(fruitName))
                .map(this::getFruitFromCsvRow)
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> readAll() {
        return fruitsList.stream()
                .filter(line -> line.matches(skipTitleFile))
                .map(this::getFruitFromCsvRow)
                .collect(Collectors.toList());
    }

    private Fruit getFruitFromCsvRow(String line) {
        String[] fields = line.split(",");
        Fruit.Operation typeOperation = getOperationFromRowCsv(fields[typeFruitOperation]);
        String nameFruit = fields[this.nameFruit];
        int quantity = Integer.parseInt(fields[quantityFruit]);
        return new Fruit(typeOperation,nameFruit,quantity);
    }

    private Fruit.Operation getOperationFromRowCsv(String rowOperation) {
        return Arrays.stream(Fruit.Operation.values())
                .filter(c -> c.getOperation().equals(rowOperation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Activities at the store is not valid, "
                        + "add new activity to Enum (Operation)"));
    }
}
