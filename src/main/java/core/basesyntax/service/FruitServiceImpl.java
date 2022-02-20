package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

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
