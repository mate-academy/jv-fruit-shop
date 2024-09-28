package core.basesyntax.app;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.OperationHandlerFactory;
import core.basesyntax.util.PropertyReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String inputFile = PropertyReader.getProperty("input.file");
        String outputFile = PropertyReader.getProperty("output.file");

        FileReader fileReader = new FileReaderImpl();
        List<String> rawData = fileReader.readFile(inputFile);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<Transaction> transactions = transactionParser.parse(rawData);

        TransactionProcessor transactionProcessor =
                new TransactionProcessorImpl(new OperationHandlerFactory());
        transactionProcessor.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(outputFile, report);
    }
}
