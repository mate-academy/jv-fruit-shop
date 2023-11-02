package core.basesyntax;

import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReaderService fileReader = new CsvFileReader();
        List<String> allLines = fileReader.read("input_file.csv");

        String report = null;
        FileWriterService fileWriter = new CsvFileWriter();
        fileWriter.write(report, "output_file.csv");
    }
}
