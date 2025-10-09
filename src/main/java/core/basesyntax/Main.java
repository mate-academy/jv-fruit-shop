package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.io.DataConverter;
import core.basesyntax.model.io.DataConverterImpl;
import core.basesyntax.model.io.FileReader;
import core.basesyntax.model.io.FileReaderImpl;
import core.basesyntax.model.io.FileWriter;
import core.basesyntax.model.io.FileWriterImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputLines = fileReader.read("reportToRead.csv");

        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> transactions = converter.convertToTransaction(inputLines);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy strategy = new OperationStrategyImpl(handlers);

        ShopService shopService = new ShopServiceImpl(strategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(shopService.getCurrentStock());
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "finalReport.csv");

        System.out.println("The report was generated and saved in the file finalReport.csv");
    }
}



