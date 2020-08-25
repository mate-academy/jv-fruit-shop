package core.basesyntax;

import core.basesyntax.processing.CsvUtils;

public class MainApp {
    public static void main(String[] args) {
        String csvInputFile = "src/main/resources/inputFile.csv";
        String csvOutputFile = "src/main/resources/outputFile.csv";
        CsvUtils csvUtils = new CsvUtils();
        csvUtils.processFile(csvInputFile);
        csvUtils.createReport(csvOutputFile);
    }
}
