package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitShopService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitsShopServiceImpl;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.SupplyOperationHandler;
import core.basesyntax.service.readservice.ReadServiceImpl;
import core.basesyntax.service.readservice.ReaderService;
import core.basesyntax.service.readservice.ReportService;
import core.basesyntax.service.readservice.ReportServiceImpl;
import core.basesyntax.service.readservice.TransactionParseService;
import core.basesyntax.service.readservice.TransactionParseServiceImpl;
import core.basesyntax.service.readservice.WriterService;
import core.basesyntax.service.readservice.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFruitShop {
    public static final String READ_DATA_FROM_STORE =
            "src/main/java/datafiles/input_data.csv";
    public static final String REPORT_DATA_FROM_STORE =
            "src/main/java/datafiles/report_data.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();

        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        ReaderService readService = new ReadServiceImpl();
        TransactionParseService transactionParseService = new TransactionParseServiceImpl();
        FruitShopService fruitShopService = new FruitsShopServiceImpl(
                new OperationStrategyImpl(operationHandlerMap));

        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> readFrom = Collections.singletonList(
                readService.readFrom(READ_DATA_FROM_STORE));
        List<FruitTransaction> parsed = transactionParseService
                .parse(readFrom.toString());
        fruitShopService.process(parsed);
        String shopReport = reportService.shopReport(Storage.map);
        writerService.write(shopReport, REPORT_DATA_FROM_STORE);
    }
}
