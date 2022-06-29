package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DESTINATION_FROM =
            "src/main/java/core/basesyntax/resources/fileInput.csv";
    private static final String DESTINATION_TO =
            "src/main/java/core/basesyntax/resources/fileReport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<Transaction.Operation, OperationHandler> mapStrategy =
                new HashMap<>();
        mapStrategy.put(Transaction.Operation.BALANCE, new BalanceHandlerImpl(fruitDao));
        mapStrategy.put(Transaction.Operation.SUPPLY, new SupplyHandlerImpl(fruitDao));
        mapStrategy.put(Transaction.Operation.PURCHASE, new PurchaseHandlerImpl(fruitDao));
        mapStrategy.put(Transaction.Operation.RETURN, new ReturnHandlerImpl(fruitDao));
        OperationService operationService =
                new OperationServiceImpl(mapStrategy);

        Reader reader = new ReaderImpl();
        List<String> operationServices = reader.getDataFromFile(DESTINATION_FROM);

        Parser parser = new ParserImpl();
        List<Transaction> transactions =
                parser.parse(operationServices);

        FruitService fruitService =
                new FruitServiceImpl(operationService);
        fruitService.process(transactions);

        ReportCreator reportCreator = new ReportCreatorImpl(fruitDao);
        String report = reportCreator.createReport();

        Writer writer = new WriterImpl();
        writer.writeDataToFile(report, DESTINATION_TO);
    }
}
