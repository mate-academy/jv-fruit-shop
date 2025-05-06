package core.basesyntax;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.dao.FruitOperationDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.report.convertdata.DataConvertor;
import core.basesyntax.report.convertdata.DataConvertorImpl;
import core.basesyntax.report.input.FileReaderImpl;
import core.basesyntax.report.input.Reader;
import core.basesyntax.report.output.FileWriterImpl;
import core.basesyntax.report.output.Writer;
import core.basesyntax.report.report.ReportGenerator;
import core.basesyntax.report.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMain {
    private static final String FILE_READ_SRC = "src/main/resources/reportToRead.csv";
    private static final String FILE_WRITE_SRC = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        Reader reader = new FileReaderImpl();
        List<String> inputReport = reader.read(FILE_READ_SRC);

        DataConvertor dataConvertor = new DataConvertorImpl();
        final List<FruitOperation>
                fruitOperations = dataConvertor.convertToTransaction(inputReport);

        Map<FruitOperation.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitOperation.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitOperation.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitOperation.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitOperation.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        FruitOperationDao repository = new FruitOperationDaoImpl();
        ShopService shopService = new ShopServiceImpl(repository,operationStrategy);
        shopService.changeQuantityStore(fruitOperations);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(Storage.SHOP_STORE);

        Writer fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, FILE_WRITE_SRC);

    }
}
