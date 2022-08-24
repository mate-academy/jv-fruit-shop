package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.RecordsReader;
import core.basesyntax.service.ReportBuilder;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.RecordsReaderImpl;
import core.basesyntax.service.impl.ReportBuilderImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "transactions.csv";
        String targetFile = "report.csv";
        RecordsReader fileReader = new RecordsReaderImpl();
        List<String> records = fileReader.readFile(inputFile);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.getTransactions(records);
        ReportBuilder reportBuilder = new ReportBuilderImpl();
        List<String> report = reportBuilder.getReport(transactions);
        ReportWriter fileWriter = new ReportWriterImpl();
        fileWriter.writeReport(targetFile, report);
    }
}
