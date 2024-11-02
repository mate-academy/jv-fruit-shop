package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.DataConverterServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
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
    public static void main(String[] args) {
        String dataBasePath = "src/DataBase.csv";

        FileReaderService readerService = new FileReaderServiceImpl();
        List<String> read = readerService.read(dataBasePath);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverterService dataConverterService = new DataConverterServiceImpl();
        List<FruitTransaction> convert = dataConverterService.convert(read);

        ShopService service = new ShopServiceImpl(operationStrategy);
        service.process(convert);

        ReportService reportService = new ReportServiceImpl();
        StorageDao storageDao = new StorageDaoImpl();
        String report = reportService.getReport(storageDao.getAll());

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, "src/result.csv");
    }
}
