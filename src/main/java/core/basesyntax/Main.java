package core.basesyntax;

import core.basesyntax.processing.RawDataProcessor;
import core.basesyntax.reader.CsvFileReader;
import core.basesyntax.report.CsvFileWriter;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READING_FILE_PATH = "testData1.csv";
    private static final String WRITING_FILE_PATH = "report.csv";

    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReader(READING_FILE_PATH);
        List<List<String>> rawData = csvFileReader.readTransactions();

        RawDataProcessor rawDataProcessor = new RawDataProcessor(rawData);
        Map<String, Integer> processedData = rawDataProcessor.process();

        CsvFileWriter csvFileWriter = new CsvFileWriter(WRITING_FILE_PATH);
        csvFileWriter.writeReport(processedData);
    }
}
