package core.basesyntax.csv.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReaderServiceImpl implements ReaderService {


    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> fruitList = new ArrayList<>();
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                fruitList.add(line);
            }
            return fruitList;
        } catch (IOException e) {
            throw new RuntimeException("Cant find file by path: " + filePath, e);
        }
    }
}
