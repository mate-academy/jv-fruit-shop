package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.impl.ConvertServiceImpl;
import core.basesyntax.service.impl.ProccesServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.service.service.ConvertService;
import core.basesyntax.service.service.ProccessService;
import core.basesyntax.service.service.ReaderService;
import core.basesyntax.service.service.Report;
import core.basesyntax.service.service.WriteService;
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
    private static final Map<Operation, OperationService> OPERATIONS_MAPS = new HashMap<>();

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> strings = readerService.readFromFile(FROM_FILE_NAME);
        OPERATIONS_MAPS.put(Operation.BALANCE, new BalanceOperation());
        OPERATIONS_MAPS.put(Operation.RETURN,new ReturnOperation());
        OPERATIONS_MAPS.put(Operation.PURCHASE,new PurchaceOperation());
        OPERATIONS_MAPS.put(Operation.SUPPLY, new SupplyOperation());
        ConvertService convertService = new ConvertServiceImpl();
        List<FruitTransaction> fruitTransactions = convertService.convertText(strings);
        ProccessService proccessService = new ProccesServiceImpl(OPERATIONS_MAPS);
        proccessService.proccessing(fruitTransactions);
        Report report = new ReportImpl();
        String reportString = report.report();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(reportString, TO_FILE_NAME);
    }
}
