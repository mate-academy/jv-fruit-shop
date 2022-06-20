package core.basesyntax;

import core.basesyntax.model.OperationWithFruit;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.OperationImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/inputFile.csv";
    public static final String REPORT_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        Map<OperationWithFruit, Operation> openFilesHandlerMap = new HashMap<>();
        openFilesHandlerMap.put(OperationWithFruit.BALANCE, new BalanceOperationHandlerImpl());
        openFilesHandlerMap.put(OperationWithFruit.PURCHASE, new PurchaseOperationHandlerImpl());
        openFilesHandlerMap.put(OperationWithFruit.SUPPLY, new SupplyOperationHandlerImpl());
        openFilesHandlerMap.put(OperationWithFruit.RETURN, new ReturnOperationHandlerImpl());

        FruitParser parseService = new FruitParserImpl();
        FileReader fileReaderService = new FileReaderImpl();
        List<String> input = fileReaderService.getDataFromFile(INPUT_FILE);
        List<TransactionInfo> fruitTransactions = parseService.parse(input);

        core.basesyntax.service.Operation operationService = new OperationImpl(openFilesHandlerMap);
        FruitService fruitShopService = new FruitServiceImpl(operationService);
        fruitShopService.process(fruitTransactions);

        ReportCreator reportService = new ReportCreatorImpl();
        FileWriter fileWriterService = new FileWriterImpl();
        fileWriterService.writerDataToFile(REPORT_FILE, reportService.createReport());
    }
}
