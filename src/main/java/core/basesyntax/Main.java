package core.basesyntax;

import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        List<String> allLines = fileReader.read("");

        String report = null;
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report, "");
    }
}
