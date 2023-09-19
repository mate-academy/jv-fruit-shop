package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ProccessService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreatorService;
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
        DataConverterService dataConverterService = new DataConverterServiceImpl();
        ProccessService proccessService = new ProccesServiceImpl(getOperationMap());
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        FileWriteService fileWriteService = new FileWriteServiceImpl();
        List<String> strings = readerService.readFromFile(FROM_FILE_NAME);
        List<FruitTransaction> fruitTransactions = dataConverterService.convertText(strings);
        proccessService.proccessing(fruitTransactions);
        String reportString = reportCreatorService.createReport();
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
