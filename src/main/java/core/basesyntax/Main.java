package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ProccessService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.Report;
import core.basesyntax.service.impl.DataConverterServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.ProccesServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaceOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/text.txt";
    private static final String TO_FILE_NAME = "src/main/resources/report.txt";

    public static void main(String[] args) {
        ReaderService readerService = new FileReaderServiceImpl();
        List<String> strings = readerService.readFromFile(FROM_FILE_NAME);
        Map<Operation, OperationService> operationMapFromOperation = getOperationMap();
        DataConverterService dataConverterService = new DataConverterServiceImpl();
        List<FruitTransaction> fruitTransactions = dataConverterService.convertText(strings);
        ProccessService proccessService = new ProccesServiceImpl(operationMapFromOperation);
        proccessService.proccessing(fruitTransactions);
        Report report = new ReportCreatorServiceImpl();
        String reportString = report.report();
        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeToFile(reportString, TO_FILE_NAME);
    }

    private static Map<Operation, OperationService> getOperationMap() {
        Map<Operation, OperationService> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceOperation());
        operationMap.put(Operation.RETURN,new ReturnOperation());
        operationMap.put(Operation.PURCHASE,new PurchaceOperation());
        operationMap.put(Operation.SUPPLY, new SupplyOperation());
        return operationMap;
    }
}
