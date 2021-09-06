package core.basesyntax;

import core.basesyntax.dao.FileDaoCsv;
import core.basesyntax.dao.FileDaoCsvImpl;
import core.basesyntax.filewriter.FileWriterImpl;
import core.basesyntax.filewriter.WriteIntoFile;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operationhandler.BalanceOperationHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseOperationHandler;
import core.basesyntax.service.operationhandler.ReturnOperationHandler;
import core.basesyntax.service.operationhandler.SupplyOperationHandler;
import core.basesyntax.service.reportdb.ReportDataStorage;
import core.basesyntax.service.reportdb.ReportDataStoragePerMapImpl;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileDaoCsv fileDaoCsv = new FileDaoCsvImpl();
        List<String> input = fileDaoCsv.getData("report.csv");
        Validator validator = new ValidatorImpl();
        if (!validator.validate(input)) {
            throw new RuntimeException("Incorrect data in the file");
        }
        OperationHandler supplyOperationHandler = new SupplyOperationHandler();
        OperationHandler balanceOperationHandler = new BalanceOperationHandler();
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
        OperationHandler returnOperationHandler = new ReturnOperationHandler();
        Map<String, OperationHandler> operationHandlerMap = new HashMap();
        operationHandlerMap.put("s", supplyOperationHandler);
        operationHandlerMap.put("b", balanceOperationHandler);
        operationHandlerMap.put("r", returnOperationHandler);
        operationHandlerMap.put("p", purchaseOperationHandler);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportDataStorage reportDataStorage =
                new ReportDataStoragePerMapImpl(new HashMap<>());
        for (String s : input) {
            String[] separate = s.split(",");
            operationStrategy.getOperationHandler(separate[0])
                    .provideOperation(reportDataStorage,
                            separate[1], Integer.parseInt(separate[2]));
        }
        WriteIntoFile fileWriter = new FileWriterImpl();
        fileWriter.writeInFile(reportDataStorage.getAllData(), "result.csv");
    }
}
