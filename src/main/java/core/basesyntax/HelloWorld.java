package core.basesyntax;

import core.basesyntax.handlers.DataConverter;
import core.basesyntax.handlers.ReportGenerator;
import core.basesyntax.handlers.filehandlers.FileReader;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.OperationStrategy;
import core.basesyntax.handlers.filehandlers.FileWriter;
import core.basesyntax.handlers.filehandlers.impl.FileReaderImpl;
import core.basesyntax.handlers.filehandlers.impl.FileWriterImpl;
import core.basesyntax.handlers.impl.*;
import core.basesyntax.handlers.service.ShopService;
import core.basesyntax.handlers.service.impl.ShopServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactions = converter.convert(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy strategy = new OperationStrategyImpl(handlers);

        ShopService service = new ShopServiceImpl(strategy);
        service.process(fruitTransactions);

        ReportGenerator generator = new ReportGeneratorImpl();
        List<String> resultingReport = generator.getReport();

        FileWriter writer = new FileWriterImpl();
        writer.write(resultingReport, "finalReport.csv");
    }
}
