import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import service.DataConverter;
import service.FileWriter;
import service.FilerReader;
import service.OperationStrategy;
import service.impl.DataConverterImpl;
import service.impl.FileWriterImpl;
import service.impl.FilerReaderImpl;
import service.impl.OperationProcessorImpl;
import service.impl.OperationStrategyImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.OperationProcessor;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        FilerReader filerReader = new FilerReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();

        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceOperation());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(OperationType.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        OperationProcessor operationProcessor = new OperationProcessorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        List<String> inputInfo = filerReader.dataToProcess();
        List<FruitTransaction> fruitTransactionList = dataConverter.fruitList(inputInfo);
        operationProcessor.processConvertedData(fruitTransactionList, operationStrategy);
        fileWriter.writeReport();
    }
}
