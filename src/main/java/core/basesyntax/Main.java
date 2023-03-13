package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ParseServiceImpl;
import core.basesyntax.service.ServiceReport;
import core.basesyntax.service.ServiceReportImpl;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.ReturnOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;
import core.basesyntax.strategy.OperatioHandlerStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String PATH_INPUT = "src/main/resources/input.csv";
    private static final String PATH_OUTPUT = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.TypeOperation, OperationHandler> listOperations = new HashMap<>();
        listOperations.put(FruitTransaction.TypeOperation.BALANCE, new BalanceOperationHandler());
        listOperations.put(FruitTransaction.TypeOperation.SUPPLY, new SupplyOperationHandler());
        listOperations.put(FruitTransaction.TypeOperation.PURCHASE, new PurchaseOperationHandler());
        listOperations.put(FruitTransaction.TypeOperation.RETURN, new ReturnOperationHandler());

        StorageServiceImpl storageService =
                new StorageServiceImpl(new OperatioHandlerStrategyImpl(listOperations));

        FileReader fileReader = new FileReaderImpl();
        List<String> daysOperations = fileReader.read(PATH_INPUT);
        ParseService parseService = new ParseServiceImpl();
        for (int i = 1; i < daysOperations.size(); i++) {
            storageService.operation(parseService.parse(daysOperations.get(i)));
        }
        FileWriter fileWriter = new FileWriterImpl();
        ServiceReport serviceReport = new ServiceReportImpl();
        fileWriter.write(PATH_OUTPUT, serviceReport.makeReport());
    }
}
