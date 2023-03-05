package core.basesyntax;

import core.basesyntax.db.StockBalance;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateData;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.GenerateReport;
import core.basesyntax.service.ProcessData;
import core.basesyntax.service.impl.CalculateDataServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.GenerateBalanceServiceImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static File csvReportFromFile = new File("src/main/resources/input.csv");
    private static String csvReportToFile = new String("src/main/resources/output.csv");

    public static void main(String[] args) {
        FileReader csvFileReader = new CsvFileReaderServiceImpl();
        List<String> fruitsListOperations = csvFileReader.read(csvReportFromFile);
        ProcessData processDataForReport = new ProcessDataServiceImpl();
        List<FruitTransaction> fruitsTransactionsList
                = processDataForReport.create(fruitsListOperations);
        CalculateData calculateDataForReport = new CalculateDataServiceImpl();
        calculateDataForReport.create(fruitsTransactionsList);
        GenerateReport generateBalance = new GenerateBalanceServiceImpl();
        String balance = generateBalance.get(StockBalance.STOCK_BALANCE);
        FileWriter writeCsvReportToFile = new CsvFileWriterServiceImpl();
        writeCsvReportToFile.write(balance, csvReportToFile);
    }
}
