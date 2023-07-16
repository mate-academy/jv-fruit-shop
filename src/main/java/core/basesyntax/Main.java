package core.basesyntax;

import db.FruitStorage;
import java.util.ArrayList;
import java.util.List;
import model.InputDataType;
import service.CsvFileReader;
import service.GenerateReport;
import service.InputDataResolver;
import service.ReportToFileWriter;
import service.TransactionOperation;

public class Main {
    private static final String INPUT_CSV = "src/main/resources/input.csv";
    private static final String REPORT_CSV = "src/main/resources/report.csv";

    public static void main(String[] args) {
        CsvFileReader fileReader = new CsvFileReader();
        ReportToFileWriter fileWriter = new ReportToFileWriter();
        FruitStorage storage = new FruitStorage();
        InputDataResolver resolver = new InputDataResolver();
        TransactionOperation operation = new TransactionOperation();
        GenerateReport report = new GenerateReport();

        List<String> fileContent = fileReader.readCsvFile(INPUT_CSV);
        ArrayList<InputDataType> resolvedData = resolver.resolveData(fileContent);

        operation.transactionOperation(resolvedData, storage);

        List<String> reportData = report.generateReport(storage.getFruitStock());

        fileWriter.writeReport(reportData, REPORT_CSV);
    }
}
