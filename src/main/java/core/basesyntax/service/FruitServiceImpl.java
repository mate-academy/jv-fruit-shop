package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.dataprocessor.DataProcessor;
import core.basesyntax.strategy.dataprocessor.DataProcessorImpl;
import core.basesyntax.strategy.reportprovider.ReportProvider;
import core.basesyntax.strategy.reportprovider.ReportProviderImpl;
import core.basesyntax.strategy.transactionparser.TransactionParser;
import core.basesyntax.strategy.transactionparser.TransactionParserImpl;
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
