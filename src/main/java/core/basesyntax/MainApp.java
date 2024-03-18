package core.basesyntax;

import core.basesyntax.model.Storage;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportProvider;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvReportProvider;
import core.basesyntax.service.impl.CsvWriterService;
import core.basesyntax.service.impl.FruitTransactionParser;
import core.basesyntax.service.impl.FruitTransactionProcessor;

public class MainApp {
    private static final String SOURCE_REPORT_NAME = "src/main/resources/report.csv";
    private static final String RESULT_REPORT_NAME = "src/main/resources/new-report";

    public static void main(String[] args) {
        generateReport(SOURCE_REPORT_NAME, RESULT_REPORT_NAME);
    }

    private static void generateReport(String sourceReportName, String newReportName) {
        FileReader fileReader = new CsvFileReader();
        TransactionParser<FruitTransaction> transactionParser
                = new FruitTransactionParser();
        TransactionProcessor<FruitTransaction> transactionProcessor
                = new FruitTransactionProcessor();
        fileReader.read(sourceReportName)
                .stream()
                .map(transactionParser::parse)
                .forEach(transactionProcessor::process);
        ReportProvider provider = new CsvReportProvider();
        FileWriter writer = new CsvWriterService();
        writer.write(provider.provide(), newReportName);
        Storage.clear();
    }
}
