package core.basesyntax;

import core.basesyntax.service.CsvReaderImpl;
import core.basesyntax.service.CsvWriterImpl;

public class Main {
    public static void main(String[] args) {

        String reportPath = "src/main/java/core/basesyntax/resources/Report.csv";
        CsvReaderImpl csvReader = new CsvReaderImpl();
        String fileContent = csvReader.readFile("src/main/java/core/basesyntax"
                + "/resources/Input.csv");
        RawLineProcessor rawLineProcessor = new RawLineProcessor();
        rawLineProcessor.fileToMap(fileContent);
        ReportFormatter reportFormatter = new ReportFormatter();
        String report = reportFormatter.formatReportAsCsvString();
        CsvWriterImpl csvWriter = new CsvWriterImpl();
        csvWriter.generateCsvReport(reportPath, report);
    }
}
