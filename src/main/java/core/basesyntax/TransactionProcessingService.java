package core.basesyntax;

import dao.CsvFileWriter;
import dao.FileReader;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.FruitTransactionParser;

public class TransactionProcessingService {
    private final FileReader fileReader;
    private final FruitTransactionParser parser;
    private final FruitShopService fruitShopService;
    private final CsvFileWriter fileWriter;

    public TransactionProcessingService(FileReader fileReader,
                                        FruitTransactionParser parser,
                                        FruitShopService fruitShopService,
                                        CsvFileWriter fileWriter) {
        this.fileReader = fileReader;
        this.parser = parser;
        this.fruitShopService = fruitShopService;
        this.fileWriter = fileWriter;
    }

    public void processTransactions(String sourceFilePath, String targetFilePath) {
        List<FruitTransaction> transactions = readAndParseTransactions(sourceFilePath);
        processTransactions(transactions);
        writeInventoryToFile(targetFilePath);
    }

    private void processTransactions(List<FruitTransaction> transactions) {
        fruitShopService.processTransactions(transactions);
    }

    private List<FruitTransaction> readAndParseTransactions(String sourceFilePath) {
        List<String> lines = fileReader.readFile(sourceFilePath);
        return parser.parse(lines);
    }

    private void writeInventoryToFile(String targetFilePath) {
        Map<String, Integer> inventory = fruitShopService.getInventory();
        fileWriter.writeFile(targetFilePath, inventory);
    }
}
