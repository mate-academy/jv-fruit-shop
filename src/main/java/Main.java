import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.FruitTransaction;
import service.Parser;
import service.Processor;
import service.Reader;
import service.Writer;
import service.impl.ParserImpl;
import service.impl.ProcessorImpl;
import service.impl.ReaderImpl;
import service.impl.WriterImpl;
import service.operation.BalanceHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseHandler;
import service.operation.ReturnHandler;
import service.operation.SupplyHandler;
import strategy.Strategy;
import strategy.StrategyImpl;

public class Main {
    private static final String toFileName = "src/main/resources/testRecord.csv";
    private static final String fromFileName = "src/main/resources/testData.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        Strategy strategy = new StrategyImpl(operationHandlerMap);
        Reader reader = new ReaderImpl();
        List<String> dataFromFile = reader.read(fromFileName);
        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactionList = parser.parse(dataFromFile);
        Processor processor = new ProcessorImpl(strategy);
        processor.process(fruitTransactionList);
        Writer writer = new WriterImpl(Storage.fruitMap);
        writer.write(toFileName);
    }
}
