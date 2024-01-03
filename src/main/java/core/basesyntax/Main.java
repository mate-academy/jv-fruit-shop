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
import strategy.FruitOperation;
import strategy.FruitOperationImpl;
import strategy.SupplyReturnOperation;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/Fruits Data.csv";
        String outputFilePath = "src/main/resources/Report.csv";

        CsvDataReader csvDataReader = new CsvDataReaderImpl();
        CsvDataParser csvDataParser = new CsvDataParserImpl();

        List<String[]> dataFromFile = csvDataReader.readDataFromFile(inputFilePath);
        List<FruitTransaction> fruitTransactions = csvDataParser.parseData(dataFromFile);

        Storage storage = new Storage();

        Map<Operation, FruitOperation> operationMap = initializeOperationMap(storage);

        CalculateStrategy calculateStrategy = new CalculateStrategy(storage, operationMap);

        fruitTransactions.forEach(calculateStrategy::processTransaction);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.generateReport(storage.getAllFruitsWithQuantity());

        CsvDataWriter csvDataWriter = new CsvDataWriterImpl();
        csvDataWriter.writeToFile(outputFilePath, report);
    }

    private static Map<Operation, FruitOperation> initializeOperationMap(Storage storage) {
        Map<Operation, FruitOperation> map = new EnumMap<>(Operation.class);
        map.put(Operation.BALANCE, new BalanceOperation(storage));
        map.put(Operation.SUPPLY, new SupplyReturnOperation(storage));
        map.put(Operation.RETURN, new SupplyReturnOperation(storage));
        map.put(Operation.PURCHASE, new FruitOperationImpl(storage));
        return map;
    }
}
