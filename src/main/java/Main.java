import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.OperationType;
import service.FileReaderServiceImpl;
import service.FileWriterServiceImpl;
import service.FruitBalanceServiceImpl;
import service.FruitPurchaseServiceImpl;
import service.FruitReturnServiceImpl;
import service.FruitSupplyServiceImpl;
import service.ReportCreateService;
import service.TransactionDto;
import service.TransactionDtoParser;
import service.interfaces.FileReaderService;
import service.interfaces.FileWriterService;
import service.interfaces.FruitOperationService;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/file.csv";
    private static final String OUTPUT_PATH = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<OperationType, FruitOperationService> strategyOperation = new HashMap<>();
        strategyOperation.put(OperationType.BALANCE,
                new FruitBalanceServiceImpl(fruitDao));
        strategyOperation.put(OperationType.SUPPLY,
                new FruitSupplyServiceImpl(fruitDao));
        strategyOperation.put(OperationType.PURCHASE,
                new FruitPurchaseServiceImpl(fruitDao));
        strategyOperation.put(OperationType.RETURN,
                new FruitReturnServiceImpl(fruitDao));

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> fileContent = fileReaderService.readFromFile(INPUT_PATH);
        List<TransactionDto> transactionList = new TransactionDtoParser()
                .parse(fileContent);
        for (TransactionDto transaction : transactionList) {
            FruitOperationService fruitOperationService = strategyOperation
                     .get(transaction.getType());
            fruitOperationService.apply(transaction);
        }

        String finalReport = new ReportCreateService(fruitDao).createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(finalReport, OUTPUT_PATH);
    }
}
