package core.basesyntax;

import core.basesyntax.model.OperationWithFruit;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitParse;
import core.basesyntax.service.FruitShop;
import core.basesyntax.service.Operation;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitParseImpl;
import core.basesyntax.service.impl.FruitShopImpl;
import core.basesyntax.service.impl.OperationImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/inputFile.csv";
    public static final String REPORT_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        Map<OperationWithFruit, OperationHandler> openFilesHandlerMap = new HashMap<>();
        FruitParse parseService = new FruitParseImpl();
        FileReader fileReaderService = new FileReaderImpl();
        List<String> input = fileReaderService.getDataFromFile(INPUT_FILE);
        List<TransactionInfo> fruitTransactions = parseService.parse(input);

        Operation operationService = new OperationImpl(openFilesHandlerMap);
        FruitShop fruitShopService = new FruitShopImpl(operationService);
        fruitShopService.process(fruitTransactions);

        ReportCreator reportService = new ReportCreatorImpl();
        FileWriter fileWriterService = new FileWriterImpl();
        fileWriterService.writerDataToFile(REPORT_FILE, reportService.createReport());
    }
}
