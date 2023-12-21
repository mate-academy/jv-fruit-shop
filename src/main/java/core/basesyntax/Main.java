package core.basesyntax;

import dao.CsvDataReader;
import dao.CsvDataReaderImpl;
import dao.CsvDataWriter;
import dao.CsvDataWriterImpl;
import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CalculateBalance;
import service.CalculateBalanceImpl;
import service.ReportGeneratorImpl;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/Fruits Data.csv";
        String outputFilePath = "src/main/resources/Report.csv";

        CsvDataReader csvDataReader = new CsvDataReaderImpl();
        List<FruitTransaction> fruitTransactions = csvDataReader.readDataFromFile(inputFilePath);

        CalculateBalance calculateBalanceOfFruits = new CalculateBalanceImpl(new Storage());
        Map<String, Integer> fruitQuantities = calculateBalanceOfFruits
                .calculateBalance(fruitTransactions);

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport(fruitQuantities);

        CsvDataWriter csvDataWriter = new CsvDataWriterImpl();
        csvDataWriter.writeToFile(outputFilePath, report);
    }
}
