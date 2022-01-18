import dao.Reader;
import dao.ReaderImpl;
import dao.Writer;
import dao.WriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.OperationStrategy;
import service.OperationStrategyImpl;
import service.Reporter;
import service.ReporterImpl;
import service.operation.BalanceOperationHandler;
import service.operation.OperationHandler;
import service.operation.PurchaseOperationHandler;
import service.operation.ReturnOperationHandler;
import service.operation.SupplyOperationHandler;
import validator.Validator;
import validator.ValidatorImpl;

public class Main {
    public static void main(String[] args) {
        OperationHandler supplyHandler = new SupplyOperationHandler();
        OperationHandler returnHandler = new ReturnOperationHandler();
        OperationHandler purchaseHandler = new PurchaseOperationHandler();
        OperationHandler balanceHandler = new BalanceOperationHandler();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", supplyHandler);
        operationHandlerMap.put("r", returnHandler);
        operationHandlerMap.put("p", purchaseHandler);
        operationHandlerMap.put("b", balanceHandler);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        Reader reader = new ReaderImpl();
        Validator validator = new ValidatorImpl();
        Reporter reporter = new ReporterImpl(validator, operationStrategy);
        Writer writer = new WriterImpl();
        String inputFilePath = "src/main/resources/input.csv";
        String reportPath = "src/main/reports/report.csv";
        List<String> data = reader.read(inputFilePath);
        writer.reportWriter(reporter.report(data), reportPath);
    }
}
