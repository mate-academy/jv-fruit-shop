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
    public static void main(String[] args) {
        generateReport("report.csv", "new-report");
    }

    public static void generateReport(String sourceReportName, String newReportName) {
        Storage storage = new Storage();
        FileReader fileReader = new CsvFileReader();
        TransactionParser<FruitTransaction> transactionParser
                = new FruitTransactionParser();
        TransactionProcessor<FruitTransaction> transactionProcessor
                = new FruitTransactionProcessor(storage);
        fileReader.read(sourceReportName)
                .map(transactionParser::parse)
                .forEach(transactionProcessor::process);
        ReportProvider provider = new CsvReportProvider();
        FileWriter writer = new CsvWriterService();
        writer.write(provider.make(storage), newReportName);
    }
}
