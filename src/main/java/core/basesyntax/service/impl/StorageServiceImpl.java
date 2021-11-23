package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.ParsedLineFromFileCsv;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.file.FileDataValidator;
import core.basesyntax.service.file.Parse;
import core.basesyntax.service.file.ReaderService;
import core.basesyntax.service.file.ReportCreator;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.strategy.FruitWorkStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private final FileDataValidator fileDataValidator;
    private final String filePath;
    private final FruitWorkStrategy fruitWork;
    private final FruitDao fruitDao;
    private final StrategyService strategyService;
    private final WriterService writerService;
    private final ReaderService readerService;
    private final ReportCreator reportCreator;
    private final Parse parse;

    public StorageServiceImpl(String filePath, FruitWorkStrategy fruitWork,
                              FruitDao fruitDao, FileDataValidator fileDataValidator,
                              StrategyService strategyService, WriterService writerService,
                              ReaderService readerService, ReportCreator reportCreator,
                              Parse parse) {
        this.filePath = filePath;
        this.fruitWork = fruitWork;
        this.fruitDao = fruitDao;
        this.fileDataValidator = fileDataValidator;
        this.strategyService = strategyService;
        this.writerService = writerService;
        this.readerService = readerService;
        this.reportCreator = reportCreator;
        this.parse = parse;
    }

    @Override
    public void workWithStorage() {
        String[] fileData = readerService.readFile();
        List<ParsedLineFromFileCsv> listData = parse.parseDataFromFile(fileData);
        fileDataValidator.checkFileData(listData);
        strategyService.workWithStrategy(listData, fruitWork, fruitDao);
        String readyToWrite = reportCreator.createResultForWriting();
        writerService.writeResultInFile(filePath, readyToWrite);
    }
}
