package core.basesyntax;

import core.basesyntax.service.impl.DataReaderImpl;

import java.util.List;

public class Main {
    private static final String FILE_NAME = "src/test.csv";

    public static void main(String[] args) {
        DataReader reader = new DataReaderImpl();
        List<String> linesFromCSV = reader.read(FILE_NAME);
    }

}
