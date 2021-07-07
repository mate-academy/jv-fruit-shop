package core.basesyntax;

import db.FruitsDao;
import db.GenericDao;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import parser.FruitShopDataParser;
import parser.Parser;
import reader.FileReaderImpl;
import service.DataProcessorFruitsImpl;
import strategy.AdditionalOperationHandler;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.PurchaseOperationHandler;
import writer.Writer;
import writer.WriterToFileImpl;

public class Main {
    private static final Path CSV_DATA_SOURCE = Path.of("src/main/resources/reportData.csv");
    private static final Path CSV_DATA_OUTPUT = Path.of("src/main/resources/FruitShopReport.csv");

    public static void main(String[] args) {
        GenericDao fruitsDao = new FruitsDao();
        Map<String, OperationHandler> map = Map.of("b", new AdditionalOperationHandler(fruitsDao),
                "s", new AdditionalOperationHandler(fruitsDao),
                "r", new AdditionalOperationHandler(fruitsDao),
                "p", new PurchaseOperationHandler(fruitsDao));
        List<String> data = new FileReaderImpl().read(CSV_DATA_SOURCE);
        OperationStrategy strategy = new OperationStrategy(map);
        Parser<List<String>> dataParser = new FruitShopDataParser(fruitsDao, strategy);
        dataParser.parse(data);
        File file = CSV_DATA_OUTPUT.toFile();
        String report = new StringBuilder("fruit, quantity")
                .append(System.lineSeparator())
                .append(new DataProcessorFruitsImpl()
                        .process(fruitsDao.getAll()))
                .toString();
        Writer<File, String> writer = new WriterToFileImpl();
        writer.write(file, report.trim());
    }
}
