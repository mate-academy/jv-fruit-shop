package core.basesyntax;


import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two filepaths - for reading and writing - "
                    + "as arguments.");
            return;
        }

        String readPath = args[0];

        FileReader fileReader = new FileReaderImpl(readPath);
        List<String> inputReport = fileReader.read();

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.parse(inputReport);

        ShopService shopService = new ShopServiceImpl();
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(shopService);

        String writePath = args[1];
        FileWriter fileWriter = new FileWriterImpl(writePath);
        fileWriter.write(resultingReport);
    }
}
