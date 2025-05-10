package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.DataConverterServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.file.FileReaderService;
import core.basesyntax.service.file.FileReaderServiceImpl;
import core.basesyntax.service.file.FileWriterService;
import core.basesyntax.service.file.FileWriterServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_BASE_PATH
            = "src/main/java/core/basesyntax/resources/DataBase.csv";
    private static final String RESULT_PATH = "src/main/java/core/basesyntax/resources/result.csv";

    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderServiceImpl();
        List<String> fileContent = readerService.read(DATA_BASE_PATH);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlers);

        DataConverterService dataConverterService = new DataConverterServiceImpl();
        List<FruitTransaction> convert = dataConverterService.convert(fileContent);

        ShopService service = new ShopServiceImpl(operationStrategy);
        service.process(convert);

        ReportService reportService = new ReportServiceImpl();
        StorageDao storageDao = new StorageDaoImpl();
        String report = reportService.getReport(storageDao.getAll());

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, RESULT_PATH);
    }
}
