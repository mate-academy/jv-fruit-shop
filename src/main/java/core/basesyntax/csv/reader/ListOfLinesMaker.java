package core.basesyntax.csv.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListOfLinesMaker {
    private static final String CSV_SEPARATOR = ",";

    public List<String[]> makeListOfLines(BufferedReader reader) throws IOException {
        List<String[]> fruitList = new ArrayList<>();
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            fruitList.add(line.split(CSV_SEPARATOR));
        }
        return fruitList;
    }
}
