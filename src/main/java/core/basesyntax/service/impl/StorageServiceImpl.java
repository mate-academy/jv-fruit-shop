package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.file.FileDataValidator;
import core.basesyntax.service.file.ReportCreator;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.service.file.impl.FileDataValidatorImpl;
import core.basesyntax.service.file.impl.ReaderServiceImpl;
import core.basesyntax.service.file.impl.ReportCreatorImpl;
import core.basesyntax.service.file.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitWorkStrategy;

public class StorageServiceImpl implements StorageService {
    private final FileDataValidator fileDataValidator;
    private final String filePath;
    private final FruitWorkStrategy fruitWork;
    private final FruitDao fruitDao;
    private final StrategyService strategyService;
    private final WriterService writerService;

    public StorageServiceImpl(String filePath, FruitWorkStrategy fruitWork, FruitDao fruitDao) {
        this.filePath = filePath;
        this.fruitWork = fruitWork;
        this.fruitDao = fruitDao;
        fileDataValidator = new FileDataValidatorImpl();
        strategyService = new StrategyServiceImpl();
        writerService = new WriterServiceImpl();
    }

    @Override
    public void workWithStorage() {
        String[] fileData = new ReaderServiceImpl(filePath).readFile();
        ReportCreator reportCreator = new ReportCreatorImpl(fruitDao);
        fileDataValidator.checkFileData(fileData, filePath);
        strategyService.workWithStrategy(fileData, fruitWork, fruitDao);
        writerService.writeResultInFile(filePath, reportCreator.createResultForWriting());
    }
}
