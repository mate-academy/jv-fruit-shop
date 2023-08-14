package core.basesyntax;

import core.basesyntax.dao.ReportsDao;
import core.basesyntax.dao.ReportsDaoImpl;
import core.basesyntax.model.Record;
import core.basesyntax.model.RecordsMapper;
import core.basesyntax.model.RecordsMapperImpl;
import core.basesyntax.model.RecordsValidator;
import core.basesyntax.model.RecordsValidatorImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.ReturnOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILENAME = "./files/input.csv";
    private static final String REPORT_FILENAME = "./files/report.csv";
    private static final Map<Record.OperationType, OperationHandler>
            OPERATION_HANDLER_MAP = new HashMap<>();

    public static void main(String[] args) {
        OPERATION_HANDLER_MAP.put(Record.OperationType.BALANCE, new BalanceOperationHandler());
        OPERATION_HANDLER_MAP.put(Record.OperationType.PURCHASE, new PurchaseOperationHandler());
        OPERATION_HANDLER_MAP.put(Record.OperationType.RETURN, new ReturnOperationHandler());
        OPERATION_HANDLER_MAP.put(Record.OperationType.SUPPLY, new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(OPERATION_HANDLER_MAP);
        ReportsDao reportsDao = new ReportsDaoImpl();
        RecordsValidator recordsValidator = new RecordsValidatorImpl();
        RecordsMapper recordsMapper = new RecordsMapperImpl(reportsDao, recordsValidator);
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(reportsDao, operationStrategy, recordsMapper);

        fruitShopService.generateDailyReport(INPUT_FILENAME, REPORT_FILENAME);
    }
}
