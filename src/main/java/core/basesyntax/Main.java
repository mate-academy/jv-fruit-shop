package core.basesyntax;

import db.FruitStorage;
import java.util.List;
import java.util.Map;
import service.CsvFileReader;
import service.GenerateReport;
import service.ReportToFileWriter;

public class Main {
    private static final String INPUT_CSV = "input.csv";
    private static final String REPORT_CSV = "report.csv";

    public static void main(String[] args) {
        CsvFileReader fileReader = new CsvFileReader();
        ReportToFileWriter fileWriter = new ReportToFileWriter();
        GenerateReport statistics = new GenerateReport();
        FruitStorage storage = new FruitStorage();

        List<String> fileContent = fileReader.readCsvFile(INPUT_CSV);
        statistics.calculateFruitsStock(fileContent);

        Map<String,Integer> fruitStock = statistics.getStock();

        storage.updateStock(fruitStock);

        fileWriter.writeReport(fruitStock, REPORT_CSV);
    }
}
