package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.CsvLineDto;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.file.Parser;
import core.basesyntax.service.file.ReaderService;
import core.basesyntax.service.file.ReportCreator;
import core.basesyntax.service.file.Validator;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.strategy.FruitWorkStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private final Validator validator;
    private final String filePath;
    private final FruitWorkStrategy fruitWork;
    private final FruitDao fruitDao;
    private final StrategyService strategyService;
    private final WriterService writerService;
    private final ReaderService readerService;
    private final ReportCreator reportCreator;
    private final Parser parser;

    public StorageServiceImpl(String filePath, FruitWorkStrategy fruitWork,
                              FruitDao fruitDao, Validator validator,
                              StrategyService strategyService, WriterService writerService,
                              ReaderService readerService, ReportCreator reportCreator,
                              Parser parser) {
        this.filePath = filePath;
        this.fruitWork = fruitWork;
        this.fruitDao = fruitDao;
        this.validator = validator;
        this.strategyService = strategyService;
        this.writerService = writerService;
        this.readerService = readerService;
        this.reportCreator = reportCreator;
        this.parser = parser;
    }

    @Override
    public void workWithStorage() {
        String[] fileData = readerService.readFile(filePath);
        List<CsvLineDto> listData = parser.parse(fileData);
        validator.checkFileData(listData);
        strategyService.getStrategy(listData, fruitWork);
        String readyToWrite = reportCreator.createReport();
        writerService.writeResultInFile(filePath, readyToWrite);
    }
}
