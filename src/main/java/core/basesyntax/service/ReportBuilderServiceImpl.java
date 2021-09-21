package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordsDao;
import core.basesyntax.fileservice.FileService;
import java.nio.file.Path;
import java.util.List;

public class ReportBuilderServiceImpl implements ReportBuilderService {
    private final FruitRecordsDao fruitRecordsDao;
    private final FileService fileService;

    public ReportBuilderServiceImpl(FruitRecordsDao fruitRecordsDao, FileService fileService) {
        this.fruitRecordsDao = fruitRecordsDao;
        this.fileService = fileService;
    }

    @Override
    public void buildReport(Path reportToFile) {
        List<String> dataAsList = fruitRecordsDao.getAllAsList();
        fileService.writeToFile(dataAsList, reportToFile);
    }
}
