package core.basesyntax;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.serviceimpl.DataConverterImpl;
import core.basesyntax.serviceimpl.FileReaderImpl;
import core.basesyntax.serviceimpl.FileWriterImpl;
import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.serviceimpl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();

        Inventory inventory = new Inventory();

        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(Operation.RETURN, new ReturnOperationHandler());

        Strategy strategy = new StrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy, inventory);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        String inputPath = "src/main/resources/reportToRead.csv";
        List<String> lines = fileReader.read(inputPath);

        List<Transaction> transactions = dataConverter.convert(lines);

        shopService.process(transactions);

        List<String> reportLines = reportGenerator.getReport(inventory);
        String outputPath = "src/main/resources/finalReport.csv";
        fileWriter.write(reportLines, outputPath);
    }
}
