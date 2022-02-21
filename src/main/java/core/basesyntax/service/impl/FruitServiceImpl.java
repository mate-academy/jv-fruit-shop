package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.StorageCleaner;
import core.basesyntax.service.StringReportBuilder;

public class FruitServiceImpl implements FruitService {
    @Override
    public void createReportFile(String incomeFile, String reportFile) {
        FruitDao fruitDao = new FruitDaoImpl();
        StringReportBuilder reportBuilder = new StringReportBuilderImpl();
        FileService fileService = new FileServiceImpl();
        StorageCleaner cleaner = new StorageCleanerImpl();
        fruitDao.putDataIntoStorage(fileService.read(incomeFile));
        fileService.write(reportFile,reportBuilder.buildReport());
        cleaner.clearStorage();
    }
}
