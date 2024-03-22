package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.interfaces.FileReader;
import core.basesyntax.service.interfaces.FileWriter;
import core.basesyntax.service.interfaces.FruitReportCreate;
import core.basesyntax.service.interfaces.TransactionParser;
import core.basesyntax.service.serviceimpl.FileReaderImpl;
import core.basesyntax.service.serviceimpl.FileWriterImpl;
import core.basesyntax.service.serviceimpl.FruitReportCreateImpl;
import core.basesyntax.service.serviceimpl.FruitTransactionParser;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.strategyimpl.BalanceOperation;
import core.basesyntax.service.strategy.strategyimpl.PurchaseOperation;
import core.basesyntax.service.strategy.strategyimpl.ReturnOperation;
import core.basesyntax.service.strategy.strategyimpl.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OPEN_FROM_FILE = "src/main/resources/fruitts.csv";
    private static final String SAVE_TO_FILE = "src/main/resources/report.csv";

    private static StorageDaoImpl storageDao = new StorageDaoImpl();

    public static void main(String[] args) {
        List<String> fileString = readFile(OPEN_FROM_FILE);
        var transactions = parse(fileString);
        Map<Operation, OperationHandler> strategy = initializeStrategy();

        transactions.forEach(dto -> {
            OperationHandler handler = strategy.get(dto.operationType());
            handler.handle(dto);
        });

        var report = prepareReport();
        System.out.println(report);

        writeDataToFile(report);
        System.out.println("Data successfully saved to file " + SAVE_TO_FILE);
    }

    private static List<String> readFile(String filePath) {
        FileReader reader = new FileReaderImpl();
        return reader.readFile(filePath);
    }

    private static List<FruitTransactionDto> parse(List<String> fileData) {
        TransactionParser parser = new FruitTransactionParser();
        return parser.parse(fileData);
    }

    private static Map<Operation, OperationHandler> initializeStrategy() {
        return Map.of(
                Operation.BALANCE, new BalanceOperation(storageDao),
                Operation.RETURN, new ReturnOperation(storageDao),
                Operation.PURCHASE, new PurchaseOperation(storageDao),
                Operation.SUPPLY, new SupplyOperation(storageDao)
        );
    }

    private static String prepareReport() {
        FruitReportCreate reportCreator = new FruitReportCreateImpl(storageDao);
        return reportCreator.createReport();
    }

    private static void writeDataToFile(String data) {
        FileWriter saver = new FileWriterImpl();
        saver.writeDataToFile(data, SAVE_TO_FILE);
    }
}
