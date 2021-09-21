package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordsDao;
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
    private final FruitRecordsDao fruitRecordsDao;

    public FruitServiceImpl(FileService fileService, FruitRecordParser fruitRecordParser,
                            OperationStrategy operationStrategy, FruitRecordsDao fruitRecordsDao) {
        this.fileService = fileService;
        this.fruitRecordParser = fruitRecordParser;
        this.operationStrategy = operationStrategy;
        this.fruitRecordsDao = fruitRecordsDao;
    }

    @Override
    public void saveFruitRecordsFromFile(Path path) {
        List<String> lines = fileService.readFromFile(path);
        List<TransactionDto> fruitRecordsList = fruitRecordParser.parse(lines);
        fruitRecordsDao.saveAll(fruitRecordsList, operationStrategy);
    }
}
