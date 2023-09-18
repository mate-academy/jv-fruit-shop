import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.OperationStrategy;
import service.ReportCreator;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.OperationProcessorImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportCreatorImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.OperationProcessor;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;

public class Main {
    private static final String DATA_FILE_PATH = "src/main/resources/inputInfo.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final Map<OperationType, OperationHandler> OPERATION_HANDLER_MAP =
            new HashMap<>();

    static {
        OPERATION_HANDLER_MAP.put(OperationType.BALANCE, new BalanceOperation());
        OPERATION_HANDLER_MAP.put(OperationType.SUPPLY, new SupplyOperation());
        OPERATION_HANDLER_MAP.put(OperationType.PURCHASE, new PurchaseOperation());
        OPERATION_HANDLER_MAP.put(OperationType.RETURN, new ReturnOperation());
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(OPERATION_HANDLER_MAP);
        OperationProcessor operationProcessor = new OperationProcessorImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        List<String> inputInfo = fileReader.dataToProcess(DATA_FILE_PATH);
        List<FruitTransaction> fruitTransactionList = dataConverter.fruitList(inputInfo);
        operationProcessor.processConvertedData(fruitTransactionList, operationStrategy);
        String report = reportCreator.createReport();
        fileWriter.writeReportToFile(REPORT_FILE_PATH, report);
    }
}
