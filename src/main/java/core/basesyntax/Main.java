package core.basesyntax;

import dao.CsvDataParser;
import dao.CsvDataParserImpl;
import dao.CsvDataReader;
import dao.CsvDataReaderImpl;
import dao.CsvDataWriter;
import dao.CsvDataWriterImpl;
import dao.Storage;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.ReportGenerator;
import service.ReportGeneratorImpl;
import strategy.BalanceOperation;
import strategy.CalculateStrategy;
import strategy.ExecuteFruitOperation;
import strategy.ExecuteFruitOperationImpl;
import strategy.SupplyReturnOperation;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/Fruits Data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        CsvDataReader csvDataReader = new CsvDataReaderImpl();
        CsvDataParser csvDataParser = new CsvDataParserImpl();

        List<String[]> dataFromFile = csvDataReader.readDataFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = csvDataParser.parseData(dataFromFile);

        Storage storage = new Storage();

        Map<Operation, ExecuteFruitOperation> operationMap = initializeOperationMap(storage);

        CalculateStrategy calculateStrategy = new CalculateStrategy(storage, operationMap);

        fruitTransactions.forEach(calculateStrategy::processTransaction);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.generateReport(storage.getAllFruitsWithQuantity());

        CsvDataWriter csvDataWriter = new CsvDataWriterImpl();
        csvDataWriter.writeToFile(OUTPUT_FILE_PATH, report);
    }

    private static Map<Operation, ExecuteFruitOperation> initializeOperationMap(Storage storage) {
        Map<Operation, ExecuteFruitOperation> map = new EnumMap<>(Operation.class);
        map.put(Operation.BALANCE, new BalanceOperation(storage));
        map.put(Operation.SUPPLY, new SupplyReturnOperation(storage));
        map.put(Operation.RETURN, new SupplyReturnOperation(storage));
        map.put(Operation.PURCHASE, new ExecuteFruitOperationImpl(storage));
        return map;
    }
}
