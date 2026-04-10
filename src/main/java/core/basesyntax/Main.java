package core.basesyntax;

import core.basesyntax.io.CsvFileReader;
import core.basesyntax.io.CsvFileReaderImpl;
import core.basesyntax.io.FileWriter;
import core.basesyntax.io.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        CsvFileReader reader = new CsvFileReaderImpl();

        List<String> input =
                reader.read("src/main/resources/reportToRead.csv");

        DataConverter converter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);

        List<FruitTransaction> transactions =
                converter.convertToTransaction(input);
        ShopService shopService = new ShopServiceImpl(strategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator =
                new ReportGeneratorImpl(shopService.getStorage());

        String report = reportGenerator.getReport();

        FileWriter writer = new FileWriterImpl();
        writer.write(report, "src/main/resources/finalReport.csv");
    }
}
