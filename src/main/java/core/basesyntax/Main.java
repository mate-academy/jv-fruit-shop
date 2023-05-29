package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.Strategy;

import java.util.List;

public class Main {
    private static final String WRITE_TO_FILE_PATH = "src/main/sourse/Report3.csv";
    private static final String VALID_SOURCE_PATH = "src/main/sourse/Data.csv";

    public static void main(String[] args) {
        List<String> fileReaderService = new FileReaderImpl(VALID_SOURCE_PATH).readFile();
        FormatTransformer transformer = new FormatTransformerImpl();
        List<FruitTransaction> fruitTransactions = transformer.formatData(fileReaderService);

        ProductDaoImpl productDao = new ProductDaoImpl();
        Strategy operationStrategy = new Strategy(productDao);

        AnalysisFile analysisFile = new AnalysisFileImpl(operationStrategy);
        analysisFile.process(fruitTransactions);
        CreateReport reportService = new  CreateReportImpl();
        CSVFileWriter csvFileWriter = new FileWriterImpl();
        List<String> products = productDao.getAll();
        List<String> report = reportService.createReport(products);
        csvFileWriter.writeFile(report, WRITE_TO_FILE_PATH);
    }
}
