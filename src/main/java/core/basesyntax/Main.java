package core.basesyntax;

import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ReportFormatter;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.ReportFormatterImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;

public class Main {
    public static void main(String[] args) {

        String reportPath = "src/main/java/core/basesyntax/resources/Report.csv";
        CsvFileReaderImpl csvReader = new CsvFileReaderImpl();
        String fileContent = csvReader.readFile("src/main/java/core/basesyntax"
                + "/resources/Input.csv");
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.fileToMap(fileContent);

        ReportFormatter reportFormatter = new ReportFormatterImpl();
        String report = reportFormatter.formatReportAsCsvString();
        CsvFileWriter csvWriter = new CsvFileWriterImpl();
        csvWriter.writeToFile(reportPath, report);
    }
}
