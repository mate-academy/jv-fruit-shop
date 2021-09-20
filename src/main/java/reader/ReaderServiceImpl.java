package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitRecord;

public class ReaderServiceImpl implements ReaderService {
    private static final int TYPE_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;

    @Override
    public List<FruitRecord> read(String path) {
        List<FruitRecord> fruitRecords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                fruitRecords.add(new FruitRecord(operation.OperationType
                        .valueOfShortName(splitLine[TYPE_COLUMN]),
                        new Fruit(splitLine[FRUIT_COLUMN]),
                        Integer.parseInt(splitLine[QUANTITY_COLUMN])));
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file " + path);
        }
        return fruitRecords;
    }
}
