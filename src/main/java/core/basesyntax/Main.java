package core.basesyntax;

import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.TransactionParser;

public class Main {
    public static void main(String[] args) {

        String reportPath = "src/main/java/core/basesyntax/resources/Report.csv";
        CsvFileReaderImpl csvReader = new CsvFileReaderImpl();
        String fileContent = csvReader.readFile("src/main/java/core/basesyntax"
                + "/resources/Input.csv");
        CsvFileWriterImpl.TransactionProcessor rawLineProcessor = new CsvFileWriterImpl
                                                                .TransactionProcessor();
        rawLineProcessor.fileToMap(fileContent);
        TransactionParser.ReportFormatter reportFormatter = new TransactionParser.ReportFormatter();
        String report = reportFormatter.formatReportAsCsvString();
        CsvFileWriterImpl csvWriter = new CsvFileWriterImpl();
        csvWriter.writeToFile(reportPath, report);
    }
}
