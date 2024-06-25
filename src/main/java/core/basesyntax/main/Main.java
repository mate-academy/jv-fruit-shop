package core.basesyntax.main;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationImpl;
import core.basesyntax.strategy.impl.ReturnOperationImpl;
import core.basesyntax.strategy.impl.SupplyOperationImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE_PATH = "src/main/resources/ReportToRead.csv";
    private static final String WRITE_FILE_PATH = "src/main/resources/FinalReport.csv";

    public static void main(String[] args) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<String> inputReport = fileReader.read(READ_FILE_PATH);

        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperationImpl(),
                Operation.PURCHASE, new PurchaseOperationImpl(),
                Operation.RETURN, new ReturnOperationImpl(),
                Operation.SUPPLY, new SupplyOperationImpl()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String finalReport = reportGenerator.getReport();

        WriterService fileWriter = new WriterServiceImpl();
        fileWriter.write(finalReport, WRITE_FILE_PATH);
    }
}
