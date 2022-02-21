package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ManipulationService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ManipulationServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.StrategyImpl;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE_PATH
            = "D:\\JAVA\\jv-fruit-shop\\src\\main\\resourses\\inputFile.cvs";
    public static final String REPORT_FILE_PATH
            = "D:\\JAVA\\jv-fruit-shop\\src\\main\\resourses\\reportFile.cvs";

    public static void main(String[] args) {
        Map<Transaction.Operation, OperationHandler> operationHandlerMap = getMap();
        Strategy strategy = new StrategyImpl(operationHandlerMap);
        List<Transaction> transactionList = new FileReaderImpl().read(INPUT_FILE_PATH);
        ManipulationService manipulationService = new ManipulationServiceImpl(strategy);
        manipulationService.manipulation(transactionList);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, REPORT_FILE_PATH);
    }

    private static Map<Transaction.Operation, OperationHandler> getMap() {
        Map<Transaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Transaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(Transaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(Transaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Transaction.Operation.RETURN, new ReturnOperation());
        return operationHandlerMap;
    }

}
