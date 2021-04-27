package core.basesyntax.csv.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class ReaderServiceImpl implements ReaderService {
    private final ListOfLinesMaker listOfLinesMaker;

    public ReaderServiceImpl() {
        listOfLinesMaker = new ListOfLinesMaker();
    }

    @Override
    public List<String[]> readFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            return listOfLinesMaker.makeListOfLines(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException("Cant find file by path: " + filePath, e);
        }
    }
}
