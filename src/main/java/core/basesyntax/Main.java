package core.basesyntax;


import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.*;
import core.basesyntax.service.*;
import core.basesyntax.serviceImp.*;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImp;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReaderImp();
        ConvertData convertData = new ConvertDataImp();
        ReportGenerate reportGenerate = new ReportGenerateImp();
        CSVWriter csvWriter = new CSVWriterImp();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImp(operationHandlerMap);
        ProcessData processData = new ProcessDataImp(operationStrategy);
        processData.operation(convertData.convertToTransaction(reader.read("reportToRead.csv")));
        csvWriter.write(reportGenerate.report(), "myReport");
    }
}