package core.basesyntax;

import core.basesyntax.models.FruitTransfer;
import core.basesyntax.models.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvDataReaderImpl;
import core.basesyntax.service.impl.CsvDataWriterImpl;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH = "src/main/resources/balance.csv";

    public static void main(String[] args) {
        //Read the data from source
        DataReader dataReader = new CsvDataReaderImpl();
        List<String> inputReport = dataReader.getDataFromFile(PATH);

        //Declare Map object "handlers" for determine operation
        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceHandler());
        handlers.put(Operation.PURCHASE, new PurchaseHandler());
        handlers.put(Operation.RETURN, new ReturnHandler());
        handlers.put(Operation.SUPPLY, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        //Convert received data from reader to particular format
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransfer> transfers = dataConverter.convertToTransfer(inputReport);

        //Process and store the data to DB
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transfers);

        //Generate a report
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String transitionalReport = reportGenerator.getReport();

        //Write report to file CSV format
        DataWriter fileWriter = new CsvDataWriterImpl(transitionalReport);
        fileWriter.writeToFile("report");
    }
}
