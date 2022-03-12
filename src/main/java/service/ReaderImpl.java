package service;

import model.Fruit;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    private static final String INPUT_FILE = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "input.csv";

    @Override
    public String read() {
        List<String> fruits;
        try {
            fruits = Files.readAllLines(Path.of(INPUT_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + INPUT_FILE);
        }
        return fruits.toString();
    }

    public List<Fruit> getFromCsvRow(String line) {
        List<Fruit> fruitList = new ArrayList<>();
        String[] fields = line.split(",");
        Fruit fruit = new Fruit();
        fruit.setOperation(fields[0]);
        fruit.setFruit(fields[1]);
        fruit.setQuantity(Integer.parseInt(fields[2]));
        fruitList.add(fruit);
        return fruitList;
    }
}

