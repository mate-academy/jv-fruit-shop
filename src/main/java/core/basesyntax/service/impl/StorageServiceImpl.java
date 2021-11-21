package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.file.FileDataValidator;
import core.basesyntax.service.file.ReportCreator;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.service.file.impl.FileDataValidatorImpl;
import core.basesyntax.service.file.impl.ReaderServiceImpl;
import core.basesyntax.service.file.impl.ReportCreatorImpl;
import core.basesyntax.service.file.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitWorkStrategy;

public class StorageServiceImpl implements StorageService {
    private static final int KEY_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_NUMBER_INDEX = 2;
    private final FileDataValidator fileDataValidator;
    private final String filePath;
    private final FruitWorkStrategy fruitWork;
    private final FruitDao fruitDao;

    public StorageServiceImpl(String filePath, FruitWorkStrategy fruitWork, FruitDao fruitDao) {
        this.filePath = filePath;
        this.fruitWork = fruitWork;
        this.fruitDao = fruitDao;
        fileDataValidator = new FileDataValidatorImpl();
    }

    @Override
    public void workWithStorage() {
        String[] fileData = new ReaderServiceImpl(filePath).readFile();
        fileDataValidator.checkFileData(fileData, filePath);

        for (String dataLine : fileData) {
            String[] dataLineArr = dataLine.split(",");
            String key = dataLineArr[KEY_INDEX];
            String fruitName = dataLineArr[FRUIT_NAME_INDEX];
            int fruitNumber = Integer.parseInt(dataLineArr[FRUIT_NUMBER_INDEX]);
            fruitWork.get(key).workWithFruitInStorage(fruitNumber, fruitName, fruitDao);
        }

        ReportCreator reportCreator = new ReportCreatorImpl(fruitDao);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeResultInFile(filePath, reportCreator);
    }
}
