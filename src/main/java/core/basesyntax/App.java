package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.operationhandler.OperationHandler;
import core.basesyntax.strategy.operationhandler.impl.BalanceOperationHandler;
import core.basesyntax.strategy.operationhandler.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.operationhandler.impl.ReturnOperationHandler;
import core.basesyntax.strategy.operationhandler.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_file.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output_file.csv";
    private static final FileReaderService FILE_READER_SERVICE = new FileReaderServiceImpl();
    private static final ProcessDataService PROCESS_DATA_SERVICE = new ProcessDataServiceImpl();
    private static final FruitDao FRUIT_DAO = new FruitDaoImpl();
    private static final ReportService REPORT_SERVICE = new ReportServiceImpl();
    private static final FileWriterService FILE_WRITER_SERVICE = new FileWriterServiceImpl();

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
        List<String> data = FILE_READER_SERVICE.readAllLines(INPUT_FILE_PATH);
        PROCESS_DATA_SERVICE.processData(data, operationHandlerMap);
        Map<String, Integer> fruitStorage = FRUIT_DAO.getAll();
        String report = REPORT_SERVICE.getReport(fruitStorage);
        FILE_WRITER_SERVICE.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
