package service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;

public class ReaderImpl implements Reader {
    private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    private static final String INPUT_FILE = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "input.csv";

    @Override
    public String read() {
        List<String> lines;
        String line;
        try {
            lines = Files.readAllLines(Path.of(INPUT_FILE));
            line = lines.stream().skip(1).collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + INPUT_FILE);
        }
        return line;
    }

    public List<Fruit> getFromCsvRow(String line) {
        List<Fruit> fruitList = new ArrayList<>();
        String[] fields = line.split(" ");
        for (String field : fields) {
            if (field.isEmpty()) {
                continue;
            }
            String[] split = field.split(",");
            Fruit fruit = new Fruit();
            fruit.setOperation(Fruit.Operation.findByAbbr(split[0]));
            fruit.setFruit(split[1]);
            fruit.setQuantity(Integer.parseInt(split[2]));
            fruitList.add(fruit);
        }
        return fruitList;
    }
}

