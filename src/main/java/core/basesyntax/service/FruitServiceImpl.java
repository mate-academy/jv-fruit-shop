package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.dataProcessor.DataProcessor;
import core.basesyntax.strategy.dataProcessor.DataProcessorImpl;
import core.basesyntax.strategy.reportProvider.ReportProvider;
import core.basesyntax.strategy.reportProvider.ReportProviderImpl;
import core.basesyntax.strategy.transactionParser.TransactionParser;
import core.basesyntax.strategy.transactionParser.TransactionParserImpl;

import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public List<String> report(String data) {
        DataProcessor dataProcessor = new DataProcessorImpl();
        ReportProvider reportProvider = new ReportProviderImpl();
        TransactionParser transactionParser = new TransactionParserImpl();

        List<FruitTransaction> transactions = dataProcessor.parseTransactions(data);
        Map<String, Integer> fruitQuantities = reportProvider.processData(transactions);
        return transactionParser.generateReport(fruitQuantities);
    }
}
