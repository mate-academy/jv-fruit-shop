package core.basesyntax;

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
        List<FruitTransaction> fruitTransactions = csvDataReader.readDataFromFile(inputFilePath);

        Storage storage = new Storage();
        CalculateBalance calculateBalanceOfFruits = new CalculateBalanceImpl(storage);
        calculateBalanceOfFruits.calculateBalance(fruitTransactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.generateReport(storage.getAllFruitsWithQuantity());

        CsvDataWriter csvDataWriter = new CsvDataWriterImpl();
        csvDataWriter.writeToFile(outputFilePath, report);
    }
}
