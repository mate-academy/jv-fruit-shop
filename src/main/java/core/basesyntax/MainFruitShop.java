package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.CalculateOperation;
import core.basesyntax.service.DataFileParser;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.impl.DataFileParserImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitReportImpl;
import core.basesyntax.strategy.OperationDefinitionImpl;
import core.basesyntax.strategy.Strategy;

import java.util.List;

public class MainFruitShop {
    private static final String INPUT_DATA_FILE = "src/main/resources/input_data.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/output_data.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> data = fileReaderService.readFromFile(INPUT_DATA_FILE);

        DataFileParser<FruitOperation> operationDataFileParser = new DataFileParserImpl();
        List<FruitOperation> fruitOperations = operationDataFileParser.parseDataFile(data);

        StorageDao fruitStorageDao = new StorageDaoImpl();
        Strategy strategy = new OperationDefinitionImpl(fruitStorageDao);

        for (FruitOperation fruitOperation: fruitOperations) {
            String operation = fruitOperation.getOperation();
            CalculateOperation calculateOperation = strategy.get(operation);
            calculateOperation.getCalculateFruit(fruitOperation.getFruit(), fruitOperation.getAmount());
        }

        StringBuilder report = new FruitReportImpl().makeReport(fruitStorageDao.getAll());
        new FileWriterServiceImpl().writeToFile(OUTPUT_DATA_FILE,report);

    }
}
