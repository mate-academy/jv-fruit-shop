package core.basesyntax.service;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.fileservice.FileService;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.parser.FruitRecordParser;
import java.nio.file.Path;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final FileService fileService;
    private final FruitRecordParser fruitRecordParser;
    private final OperationStrategy operationStrategy;
    private final FruitStorageDao fruitStorageDao;

    public FruitServiceImpl(FileService fileService, FruitRecordParser fruitRecordParser,
                            OperationStrategy operationStrategy, FruitStorageDao fruitStorageDao) {
        this.fileService = fileService;
        this.fruitRecordParser = fruitRecordParser;
        this.operationStrategy = operationStrategy;
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void saveFruitRecordsFromFile(Path path) {
        List<String[]> lines = fileService.readFromFile(path);
        List<TransactionDto> fruitRecordsList = fruitRecordParser.parse(lines);
        fruitStorageDao.saveAll(fruitRecordsList, operationStrategy);
    }
}
