package core.basesyntax;

import core.basesyntax.io.read.impl.ReportReaderImpl;
import core.basesyntax.io.read.impl.csv.CsvReaderImpl;
import core.basesyntax.io.read.ReportReader;
import core.basesyntax.io.write.ReportWriter;
import core.basesyntax.io.write.impl.ReportWriterImpl;
import core.basesyntax.io.write.impl.csv.CsvWriterImpl;
import core.basesyntax.storage.impl.StorageImpl;
import core.basesyntax.utils.convert.ReportConverter;
import core.basesyntax.utils.convert.ReportConverterImpl;
import core.basesyntax.utils.convert.csv.CsvConverterImpl;
import core.basesyntax.utils.generate.ReportGenerator;
import core.basesyntax.utils.generate.impl.ReportGeneratorImpl;
import core.basesyntax.utils.generate.impl.csv.CsvGeneratorImpl;
import core.basesyntax.utils.process.impl.ShopServiceImpl;
import core.basesyntax.utils.transaction.FruitTransaction;
import core.basesyntax.utils.transaction.handlers.OperationHandlerFactory;

import java.util.List;

import java.io.FileNotFoundException;

public class Main {
    private static final String CSV_FILE_PATH = "/";

    public static void main(String[] args) {
        ReportReader csvReader = new CsvReaderImpl(CSV_FILE_PATH);
        String transactionsReport = readData(csvReader);
        ReportConverter csvConverter = new CsvConverterImpl(transactionsReport);
        List<FruitTransaction> transactions = convertData(csvConverter);
        OperationHandlerFactory operationHandlerFactory = new OperationHandlerFactory();
        StorageImpl storage = new StorageImpl();
        ShopServiceImpl shop = new ShopServiceImpl(operationHandlerFactory, storage);
        shop.process(transactions);
        ReportGenerator csvGenerator = new CsvGeneratorImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl(csvGenerator);
        String report = reportGenerator.getReport(storage);
        ReportWriter csvWriter = new CsvWriterImpl();
        ReportWriter reportWriter = new ReportWriterImpl(csvWriter);
        reportWriter.write(report, CSV_FILE_PATH);
    }

    private static String readData(ReportReader concreteReader) {
        try {
            ReportReader reader = new ReportReaderImpl(concreteReader);
            return reader.readReport();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file provided does not exist");
        }
    }

    private static List<FruitTransaction> convertData(ReportConverter concreteConverter) {
        ReportConverter converter = new ReportConverterImpl(concreteConverter);
        return converter.convert();
    }
}
