package core.basesyntax;

import core.basesyntax.handlers.DataConverter;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.OperationStrategy;
import core.basesyntax.handlers.ReportGenerator;
import core.basesyntax.handlers.filehandlers.FileReader;
import core.basesyntax.handlers.filehandlers.FileWriter;
import core.basesyntax.handlers.filehandlers.impl.FileReaderImpl;
import core.basesyntax.handlers.filehandlers.impl.FileWriterImpl;
import core.basesyntax.handlers.impl.BalanceHandler;
import core.basesyntax.handlers.impl.DataConverterImpl;
import core.basesyntax.handlers.impl.OperationStrategyImpl;
import core.basesyntax.handlers.impl.PurchaseOperation;
import core.basesyntax.handlers.impl.ReportGeneratorImpl;
import core.basesyntax.handlers.impl.ReturnOperation;
import core.basesyntax.handlers.impl.SupplyOperation;
import core.basesyntax.handlers.service.ShopService;
import core.basesyntax.handlers.service.impl.ShopServiceImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE);

        DataConverter converter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy strategy = new OperationStrategyImpl(handlers);

        List<FruitTransaction> fruitTransactions = converter.convert(inputReport);
        ShopService service = new ShopServiceImpl(strategy);
        service.process(fruitTransactions);

        ReportGenerator generator = new ReportGeneratorImpl();
        List<String> resultingReport = generator.getReport();
        String reportAsString = String.join(System.lineSeparator(), resultingReport);

        FileWriter writer = new FileWriterImpl();
        writer.write(reportAsString, OUTPUT_FILE);
    }
}
