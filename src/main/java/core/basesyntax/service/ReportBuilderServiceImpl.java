package core.basesyntax.service;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.fileservice.FileService;
import java.nio.file.Path;
import java.util.List;

public class ReportBuilderServiceImpl implements ReportBuilderService {
    private final FruitStorageDao fruitStorageDao;
    private final FileService fileService;

    public ReportBuilderServiceImpl(FruitStorageDao fruitStorageDao, FileService fileService) {
        this.fruitStorageDao = fruitStorageDao;
        this.fileService = fileService;
    }

    @Override
    public void buildReport(Path reportToFile) {
        List<String> dataAsList = fruitStorageDao.getAllAsList();
        fileService.writeToFile(dataAsList, reportToFile);
    }
}
