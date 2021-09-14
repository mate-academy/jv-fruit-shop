package core.basesyntax;

import core.basesyntax.dao.FileDaoCsv;
import core.basesyntax.dao.FileDaoCsvImpl;
import core.basesyntax.filewriter.FileWriterImpl;
import core.basesyntax.filewriter.WriteIntoFile;
import core.basesyntax.operationprovider.DataProcessor;
import core.basesyntax.operationprovider.DataProcessorImpl;
import core.basesyntax.service.operationhandler.BalanceOperationHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.Operations;
import core.basesyntax.service.operationhandler.PurchaseOperationHandler;
import core.basesyntax.service.operationhandler.ReturnOperationHandler;
import core.basesyntax.service.operationhandler.SupplyOperationHandler;
import core.basesyntax.service.operationstrategy.OperationStrategy;
import core.basesyntax.service.operationstrategy.OperationStrategyImpl;
import core.basesyntax.service.reportdb.ReportDataStorage;
import core.basesyntax.service.reportdb.ReportDataStoragePerMapImpl;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FROM_FILE_NAME = "report.csv";
    public static final String TO_FILE_NAME = "result.csv";

    public static void main(String[] args) {
        FileDaoCsv fileDaoCsv = new FileDaoCsvImpl();
        List<String> input = fileDaoCsv.getData(FROM_FILE_NAME);
        Validator validator = new ValidatorImpl();
        if (!validator.validate(input)) {
            throw new RuntimeException("Incorrect data in the file");
        }
        OperationHandler supplyOperationHandler = new SupplyOperationHandler();
        OperationHandler balanceOperationHandler = new BalanceOperationHandler();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
        OperationHandler returnOperationHandler = new ReturnOperationHandler();
        Map<String, OperationHandler> operationHandlerMap = new HashMap();
        operationHandlerMap.put(String.valueOf(Operations.s), supplyOperationHandler);
        operationHandlerMap.put(String.valueOf(Operations.b), balanceOperationHandler);
        operationHandlerMap.put(String.valueOf(Operations.r), returnOperationHandler);
        operationHandlerMap.put(String.valueOf(Operations.p), purchaseOperationHandler);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportDataStorage reportDataStorage =
                new ReportDataStoragePerMapImpl(new HashMap<>());
        DataProcessor dataProcessor = new DataProcessorImpl();
        dataProcessor.handleInput(input, operationStrategy, reportDataStorage);
        WriteIntoFile fileWriter = new FileWriterImpl();
        fileWriter.writeInFile(reportDataStorage.getAllData(), TO_FILE_NAME);
    }
}
