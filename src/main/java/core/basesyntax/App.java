package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.entity.FruitTransaction.Operation;
import core.basesyntax.service.calculationservice.FruitService;
import core.basesyntax.service.calculationservice.FruitsServiceImpl;
import core.basesyntax.service.handler.BalanceOperation;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.PurchaseOperation;
import core.basesyntax.service.handler.ReturnOperation;
import core.basesyntax.service.handler.SupplyOperation;
import core.basesyntax.service.handlerservice.HandlerServiceImpl;
import core.basesyntax.service.nio.FileService;
import core.basesyntax.service.nio.FileServiceImpl;
import core.basesyntax.service.parser.TransactionParser;
import core.basesyntax.service.parser.TransactionParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static final String IN_FILE = "src/main/resources/fruit.csv";
    public static final String OUT_FILE = "src/main/resources/resultFruits.csv";

    public static void main(String[] args) {

        Map<Operation, OperationHandler> mapOperation = new HashMap<>();
        mapOperation.put(Operation.BALANCE, new BalanceOperation());
        mapOperation.put(Operation.PURCHASE, new PurchaseOperation());
        mapOperation.put(Operation.RETURN, new ReturnOperation());
        mapOperation.put(Operation.SUPPLY, new SupplyOperation());

        FileService fileService = new FileServiceImpl();
        List<String> read = fileService.read(IN_FILE);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> parser = transactionParser.parser(read);
        FruitService fruitService = new FruitsServiceImpl(new FruitsDaoImpl(),
                new HandlerServiceImpl(mapOperation));
        fruitService.processTransactions(parser);
        FruitsDao fruitsDao = new FruitsDaoImpl();
        Map<String, Integer> allFruits = fruitsDao.getAllFruits();

        fileService.write(OUT_FILE, allFruits);

    }
}
