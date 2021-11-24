import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import service.FileReaderService;
import service.FileWriterService;
import service.Parser;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.ParserImpl;
import service.impl.ValidatorImpl;
import strategy.AddOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;

public class Main {
    private static final Map<String, OperationHandler> map = new HashMap<>();
    private static final String inputFilePath = "src\\main\\resources\\fruits.csv";
    private static final String outputFilePath = "src\\main\\resources\\outFile.csv";

    static {
        map.put("b", new AddOperationHandler());
        map.put("s", new AddOperationHandler());
        map.put("p", new AddOperationHandler());
        map.put("r", new PurchaseOperationHandler());
    }

    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderServiceImpl();
        Parser parser = new ParserImpl(new ValidatorImpl());
        List<String> lines = readerService.readFromFile(inputFilePath);
        for (int i = 1; i < lines.size(); i++) {
            TransactionDto transactionDto = parser.parsLine(lines.get(i));
            map.get(transactionDto.getOperation()).apply(transactionDto);
        }
        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.write(outputFilePath);
    }
}
