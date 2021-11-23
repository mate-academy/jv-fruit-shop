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
    private static final String readFromFile = "src\\main\\resources\\fruits.csv";
    private static final String writeToFile = "src\\main\\resources\\outFile.csv";

    static {
        map.put("b", new AddOperationHandler());
        map.put("s", new AddOperationHandler());
        map.put("p", new AddOperationHandler());
        map.put("r", new PurchaseOperationHandler());
    }

    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderServiceImpl();
        Parser parser = new ParserImpl(new ValidatorImpl());
        List<String> list = readerService.readFromFile(readFromFile);
        for (String line : list) {
            TransactionDto transactionDto = parser.parsLine(line);
            map.get(transactionDto.getOperation()).apply(transactionDto);
        }
        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.write(writeToFile);
    }
}
