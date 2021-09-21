package core.basesyntax;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.report.Report;
import core.basesyntax.service.report.ReportCreatorImpl;
import core.basesyntax.service.strategy.operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.DecreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.IncreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.OperationHandler;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "src/main/resources/inputData.csv";
        String reportFileName = "src/main/resources/report.csv";

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitRecordDto.OperationType.BALANCE.getType(),
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.PURCHASE.getType(),
                new DecreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.SUPPLY.getType(),
                new IncreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.RETURN.getType(),
                new IncreaseOperationHandlerImpl());


        Report report = new ReportCreatorImpl();
        report.createReport(inputFileName, reportFileName);
    }
}
