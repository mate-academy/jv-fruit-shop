package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.transaction.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.converter.DataConverterImpl;
import core.basesyntax.service.impl.reader.FileReaderImpl;
import core.basesyntax.service.impl.report.ReportGeneratorImpl;
import core.basesyntax.service.impl.shop.ShopServiceImpl;
import core.basesyntax.service.impl.writer.FileWriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceOperation;
import core.basesyntax.strategy.handler.impl.PurchaseOperation;
import core.basesyntax.strategy.handler.impl.ReturnOperation;
import core.basesyntax.strategy.handler.impl.SupplyOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path ROOT_PATH = Path.of("src", "main", "resources");
    private static final Path INPUT_PATH = ROOT_PATH.resolve("reportToRead.csv");
    private static final Path REPORT_PATH = ROOT_PATH.resolve("finalReport.csv");

    public static void main(String[] arg) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        final String resultingReport = getResultingReport(operationHandlers);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, REPORT_PATH.toString());
    }

    private static String getResultingReport(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        final FruitDao fruitDao = getFruitDao(operationStrategy);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        return reportGenerator.getReport(fruitDao);
    }

    private static FruitDao getFruitDao(OperationStrategy operationStrategy) {
        DataReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(INPUT_PATH.toString());

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        Storage storage = new StorageImpl();
        FruitDao fruitDao = new FruitDaoImpl(storage);
        shopService.process(transactions, fruitDao);
        return fruitDao;
    }
}
