package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.ConvertData;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.CsvWriter;
import core.basesyntax.service.ProcessData;
import core.basesyntax.service.ReportGenerate;
import core.basesyntax.service.imp.ConvertDataImp;
import core.basesyntax.service.imp.CsvReaderImp;
import core.basesyntax.service.imp.CsvWriterImp;
import core.basesyntax.service.imp.ProcessDataImp;
import core.basesyntax.service.imp.ReportGenerateImp;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.imp.OperationStrategyImp;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler()
        );
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImp(operationHandlerMap);
        ProcessData processData = new ProcessDataImp(operationStrategy);
        CsvReader reader = new CsvReaderImp();
        ConvertData convertData = new ConvertDataImp();
        processData.operation(convertData.convertToTransaction(reader.read("reportToRead.csv")));
        ReportGenerate reportGenerate = new ReportGenerateImp();
        CsvWriter csvWriter = new CsvWriterImp();
        csvWriter.write(reportGenerate.report(), "myReport");
    }
}
