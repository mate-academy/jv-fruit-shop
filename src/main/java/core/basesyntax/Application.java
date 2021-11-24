package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> activities = reader.readFromFile(INPUT_FILE_PATH);
        activities.remove(0);

        Parser<TransactionDto> parser = new ParserImpl(new ValidatorImpl());
        List<TransactionDto> transactions = new ArrayList<>();
        for (String line : activities) {
            transactions.add(parser.parseLine(line));
        }

        FruitStorageDao fruitDao = new FruitStorageDaoImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler(fruitDao));
        operationHandlerMap.put("s", new SupplyOperationHandler(fruitDao));
        operationHandlerMap.put("p", new PurchaseOperationHandler(fruitDao));
        operationHandlerMap.put("r", new ReturnOperationHandler(fruitDao));
        for (TransactionDto transaction : transactions) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }

        String report = new ReportCreatorImpl().makeReport();
        new WriterImpl().writeToFile(OUTPUT_FILE_PATH, report);
    }
}
