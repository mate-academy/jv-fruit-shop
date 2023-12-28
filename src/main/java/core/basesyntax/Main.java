package core.basesyntax;

import dao.CsvDataParser;
import dao.CsvDataParserImpl;
import dao.CsvDataReader;
import dao.CsvDataReaderImpl;
import dao.CsvDataWriter;
import dao.CsvDataWriterImpl;
import db.Storage;
import java.util.List;
import model.FruitTransaction;
import service.CalculateBalance;
import service.CalculateBalanceImpl;
import service.ReportGenerator;
import service.ReportGeneratorImpl;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/Fruits Data.csv";
        String outputFilePath = "src/main/resources/Report.csv";

        CsvDataReader csvDataReader = new CsvDataReaderImpl();
        CsvDataParser csvDataParser = new CsvDataParserImpl(csvDataReader);

        List<FruitTransaction> fruitTransactions = csvDataParser.parseData(inputFilePath);

        Storage storage = new Storage();
        CalculateBalance calculateBalanceOfFruits = new CalculateBalanceImpl(storage);
        calculateBalanceOfFruits.calculateBalance(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.generateReport(storage.getAllFruitsWithQuantity());

        CsvDataWriter csvDataWriter = new CsvDataWriterImpl();
        csvDataWriter.writeToFile(outputFilePath, report);
    }
}
