package core.basesyntax;

import DAO.DAOFruit;
import DAO.DAOFruitImplem;
import Implementation.FileReaderImpl;
import Implementation.FileWriterImpl;
import Implementation.FruitTransactionParserImpl;
import Implementation.FruitTransactionServiceImpl;
import Implementation.ReportServiceImpl;
import Operations.BalanceOperation;
import Operations.OperationHandler;
import Operations.PurchaseOperation;
import Operations.ReturnOperation;
import Operations.SupplyOperation;
import Service.FileReader;
import Service.FileWriter;
import Service.FruitParser;
import Service.FruitService;
import Service.ReportService;
import Strategy.OperationStrategy;
import Strategy.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {

    public static void main(String[] args) {
        DAOFruit fruitDao = new DAOFruitImplem();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitDao));
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(fruitDao));
        FileReader fileReader = new FileReaderImpl();

        List<String> inputStrings = fileReader.readFromFile( "src/main/java/core/basesyntax/resources/input.csv");

        FruitParser parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactions =
                parser.parse(inputStrings);

        Strategy strategy = new Strategy(operationHandlersMap);
        FruitService fruitService =
                new FruitTransactionServiceImpl(strategy);
        fruitService.process(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.writeReport(Storage.fruits);

        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(report,             "src/main/java/core/basesyntax/resources/report.csv");

    }
}
