import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.OutputService;
import service.ParserService;
import service.ReaderService;
import service.WriterService;
import service.impl.OutputServiceImpl;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlersMap = new HashMap<>();
        handlersMap.put("b", new BalanceOperationHandler());
        handlersMap.put("s", new SupplyOperationHandler());
        handlersMap.put("p", new PurchaseOperationHandler());
        handlersMap.put("r", new ReturnOperationHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> readData = readerService.read(INPUT_FILE_PATH);

        ParserService parserService = new ParserServiceImpl();
        for (String string : readData) {
            Transaction transaction = parserService.parse(string);
            OperationHandler operationHandler = handlersMap.get(transaction.getOperation());
            operationHandler.process(transaction.getFruit(), transaction.getQuantity());
        }

        OutputService outputService = new OutputServiceImpl();
        String output = outputService.getOutput();

        WriterService writer = new WriterServiceImpl();
        writer.write(OUTPUT_FILE_PATH, output);
    }
}
