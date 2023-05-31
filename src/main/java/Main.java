import db.Storage;
import java.util.List;
import models.FruitTransaction;
import service.Parser;
import service.Processor;
import service.Reader;
import service.Writer;
import service.impl.ParserImpl;
import service.impl.ProcessorImpl;
import service.impl.ReaderImpl;
import service.impl.WriterImpl;
import service.operation.OperationHandlerMap;
import strategy.Strategy;
import strategy.StrategyImpl;

public class Main {
    private static final String toFileName = "src/main/resources/testRecord.csv";
    private static final String fromFileName = "src/main/resources/testData.csv";

    public static void main(String[] args) {
        Strategy strategy = new StrategyImpl(OperationHandlerMap.operationHandlerMap);
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
