package core.basesyntax.dao;

import core.basesyntax.exceptions.InvalidLineException;
import core.basesyntax.exceptions.NullFileNameException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReader implements DataReader {
    private static final int NECESSARY_LINE_ELEMENT_NUMBER = 3;
    private static final String EMPTY_LINE = "";
    private final String fileName;
    private final List<String> transactions;

    public FruitFileReader(String fileName) {
        if (fileName == null) {
            throw new NullFileNameException("Can't get a file with NULL name");
        }
        this.fileName = fileName;
        transactions = new ArrayList<>();
    }

    @Override
    public List<String> readDataLines() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                readLine(bufferedReader.readLine());
            }
            return transactions;
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file " + fileName, e);
        }
    }

    private void readLine(String line) {
        if (line.equals(EMPTY_LINE)) {
            throw new InvalidLineException("Can't read empty line inside the file");
        }
        if (line.split(",").length != NECESSARY_LINE_ELEMENT_NUMBER) {
            throw new InvalidLineException();
        }
        transactions.add(line);
    }
}
