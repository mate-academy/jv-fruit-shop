package service.writereadcsv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import model.Fruit;

public class FruitServiceWriterCsvImpl implements FruitServiceWriterCsv {
    private final String fileName = "src/main/resources/outputdate/report.csv";
    private File file;

    public FruitServiceWriterCsvImpl() {
        file = new File(fileName);
        try {
            Files.write(file.toPath(),"fruit,quantity".getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write a title to file " + fileName, e);
        }
    }

    @Override
    public void write(Fruit fruit) {
        List<Fruit> fruitList = Arrays.asList(fruit);
        writeAll(fruitList);
    }

    @Override
    public void writeAll(List<Fruit> list) {
        for (Fruit fruit: list) {
            try {
                Files.write(file.toPath(),System.lineSeparator().getBytes(),
                        StandardOpenOption.APPEND);
                Files.write(file.toPath(),fruit.getName().getBytes(),
                        StandardOpenOption.APPEND);
                Files.write(file.toPath(),",".getBytes(),
                        StandardOpenOption.APPEND);
                Files.write(file.toPath(),String.valueOf(fruit.getQuantity()).getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to the file " + fileName, e);
            }
        }
    }
}
