package core.basesyntax;

import core.basesyntax.handlers.FruitOperationHandler;
import core.basesyntax.handlers.impl.AddOperation;
import core.basesyntax.handlers.impl.RemoveOperation;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.dtos.FruitDtoTransaction;
import core.basesyntax.services.impl.FileReaderImpl;
import core.basesyntax.services.impl.FileWriterImpl;
import core.basesyntax.services.impl.FruitDtoTransactionParserImpl;
import core.basesyntax.services.impl.FruitShopServiceImpl;
import core.basesyntax.services.interfaces.FileReader;
import core.basesyntax.services.interfaces.FileWriter;
import core.basesyntax.services.interfaces.FruitDtoTransactionParser;
import core.basesyntax.services.interfaces.FruitShopService;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationMain {
    private static final String INPUT_FILE_NAME = "src" + File.separator + "main"
            + File.separator + "java" + File.separator + "core" + File.separator
            + "basesyntax" + File.separator + "resources" + File.separator
            + "fruit_shop_report.csv";
    private static final String REPORT_FILE_NAME = "src" + File.separator + "main"
            + File.separator + "java" + File.separator + "core" + File.separator
            + "basesyntax" + File.separator + "resources" + File.separator
            + "fruit_shop_final_report.csv";

    public static void main(String[] args) {
        Map<OperationType, FruitOperationHandler> operationHandlerMap = new HashMap<>();
        FruitOperationHandler addOperation = new AddOperation();
        FruitOperationHandler removeOperation = new RemoveOperation();
        operationHandlerMap.put(OperationType.BALANCE, addOperation);
        operationHandlerMap.put(OperationType.SUPPLY, addOperation);
        operationHandlerMap.put(OperationType.PURCHASE, removeOperation);
        operationHandlerMap.put(OperationType.RETURN, addOperation);

        FileReader fileReader = new FileReaderImpl();
        List<String> lines = fileReader.getLinesFromFile(INPUT_FILE_NAME);

        FruitDtoTransactionParser fruitDtoTransactionParser = new FruitDtoTransactionParserImpl();
        List<FruitDtoTransaction> fruitDtoTransactions = fruitDtoTransactionParser.parse(lines);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationHandlerMap);
        fruitShopService.applyTransactions(fruitDtoTransactions);
        String report = fruitShopService.createReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, REPORT_FILE_NAME);
    }
}
