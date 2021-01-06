package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.work.with.file.ReadInformationFromFile;
import core.basesyntax.service.work.with.file.ReadInformationFromFileImpl;
import core.basesyntax.service.work.with.file.Report;
import core.basesyntax.service.work.with.file.ReportImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation.Type, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.Type.B, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.Type.R, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.Type.P, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.Type.S, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ShopService shopService = new ShopServiceImpl(new FruitDaoImpl(), operationStrategy);
        ReadInformationFromFile readInformationFromFile = new ReadInformationFromFileImpl();
        String fromFileName = "database.csv";
        List<String> allLinesFromFile = readInformationFromFile.getAllLines(fromFileName);
        shopService.doOperation(allLinesFromFile);

        Report report = new ReportImpl();
        String reportString = report.writeReportToString();
        String toFileName = "report.csv";
        report.writeReportToFile(reportString, toFileName);
    }
}
