package core.basesyntax.service;

public interface CsvFileReader {
    String readFromFile();

    String[] getDataFromFile(String filePath);
}
