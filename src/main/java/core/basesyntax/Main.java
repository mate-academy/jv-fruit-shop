package core.basesyntax;

import core.basesyntax.service.CsvReaderImpl;
import core.basesyntax.service.CsvWriterImpl;
import core.basesyntax.service.TransactionParser;

public class Main {
    public static void main(String[] args) {

        String reportPath = "src/main/java/core/basesyntax/resources/Report.csv";
        CsvReaderImpl csvReader = new CsvReaderImpl();
        String fileContent = csvReader.readFile("src/main/java/core/basesyntax"
                + "/resources/Input.csv");
        CsvWriterImpl.TransactionProcessor rawLineProcessor = new CsvWriterImpl
                                                                .TransactionProcessor();
        rawLineProcessor.fileToMap(fileContent);
        TransactionParser.ReportFormatter reportFormatter = new TransactionParser.ReportFormatter();
        String report = reportFormatter.formatReportAsCsvString();
        CsvWriterImpl csvWriter = new CsvWriterImpl();
        csvWriter.generateCsvReport(reportPath, report);
    }
}
