package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitShopDataParser;
import core.basesyntax.service.impl.FruitShopRecordValidator;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationPerformer;
import core.basesyntax.strategy.OperationPerformerStrategy;
import core.basesyntax.strategy.OperationPerformerStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_PATH = "src/main/resources/data.csv";
    private static final String RESULT_FILE_PATH = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Validator validator = new FruitShopRecordValidator();
        FileReader fileReader = new FileReaderImpl();
        List<String> records = fileReader.readLines(SOURCE_FILE_PATH);
        Parser parser = new FruitShopDataParser(validator);
        List<FruitTransaction> fruitTransactionList = parser
                .getTransactions(records);

        StorageDao dao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationPerformer> map = new MapInitializer(dao).initMap();
        OperationPerformerStrategy strategy = new OperationPerformerStrategyImpl(map);
        OperationService operationService = new OperationServiceImpl(strategy, dao);
        Map<Fruit, Integer> fruitStorage = operationService.processOperations(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        List<String> fruitReport = reportService.makeReport(fruitStorage);

        FileWriter writer = new FileWriterImpl();
        writer.writeLines(RESULT_FILE_PATH, fruitReport);
    }
}
