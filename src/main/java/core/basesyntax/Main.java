package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.dao.FruitBalanceDao;
import core.basesyntax.dao.FruitBalanceDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitBalanceService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitBalanceServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.BalanceOperation;
import core.basesyntax.service.strategy.impl.PurchaseOperation;
import core.basesyntax.service.strategy.impl.ReturnOperation;
import core.basesyntax.service.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> inputReport = fileReader.read(INPUT_FILE_PATH);

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        FruitBalanceDao fruitBalanceDao = new FruitBalanceDaoImpl();
        FruitBalanceService fruitBalanceService = new FruitBalanceServiceImpl(fruitBalanceDao);
        ShopService shopService = new ShopServiceImpl(operationStrategy, fruitBalanceService);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(new FruitBalanceDaoImpl());
        String resultingReport = reportGenerator.getReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(resultingReport, OUTPUT_FILE_PATH);
    }
}
