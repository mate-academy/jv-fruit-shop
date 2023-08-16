package core.basesyntax;

import dao.FruitStorageDao;
import dao.FruitStorageDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.InputDataType;
import service.GenerateReport;
import service.InputDataResolver;
import service.ReaderService;
import service.TransactionOperation;
import service.WriterService;
import service.impl.GenerateReportImpl;
import service.impl.InputDataResolverImpl;
import service.impl.ReaderServiceImpl;
import service.impl.TransactionOperationImpl;
import service.impl.WriterServiceImpl;

public class Main {
    private static final String INPUT_CSV = "src/main/resources/input.csv";
    private static final String REPORT_CSV = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        WriterService writer = new WriterServiceImpl();
        FruitStorageDao fruitStorage = new FruitStorageDaoImpl();
        InputDataResolver resolver = new InputDataResolverImpl();
        TransactionOperation transactionOperation = new TransactionOperationImpl();
        GenerateReport report = new GenerateReportImpl();

        List<String> fileContent = reader.read(INPUT_CSV);
        ArrayList<InputDataType> resolvedData = resolver.resolveData(fileContent);

        transactionOperation.execute(resolvedData, fruitStorage);

        List<String> reportData = report.generateReport(fruitStorage.getFruits());

        writer.write(reportData, REPORT_CSV);
    }
}
