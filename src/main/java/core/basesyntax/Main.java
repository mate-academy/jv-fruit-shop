package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.DataConverterService;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.ReportGeneratorService;
import core.basesyntax.services.ShopService;
import core.basesyntax.services.impl.DataConverterServiceImpl;
import core.basesyntax.services.impl.FileReaderServiceImpl;
import core.basesyntax.services.impl.FileWriterServiceImpl;
import core.basesyntax.services.impl.ReportGeneratorServiceImpl;
import core.basesyntax.services.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String REPORT_PATH = "src/main/resources/reportToRead.csv";
    private static final String FINAL_REPORT_PATH = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> inputReport = fileReader.read(REPORT_PATH);

        OperationStrategy operationStrategy = getOperationStrategy(fruitDao);

        DataConverterService dataConverter = new DataConverterServiceImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl(fruitDao);
        String resultingReport = reportGenerator.getReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(resultingReport, FINAL_REPORT_PATH);
    }

    private static OperationStrategy getOperationStrategy(FruitDao fruitDao) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map
                .of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao),
                        FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao));

        return new OperationStrategyImpl(operationHandlers);
    }
}
