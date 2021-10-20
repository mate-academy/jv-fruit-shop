package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;
    private FruitParser fruitParser;
    private DataValidator dataValidator;
    private ReportCreator reportCreator;
    private ReportWriter reportWriter;

    public FruitServiceImpl(FruitDao fruitDao,
                            FruitParser fruitParser,
                            DataValidator dataValidator,
                            ReportCreator reportCreator,
                            ReportWriter reportWriter) {
        this.fruitDao = fruitDao;
        this.fruitParser = fruitParser;
        this.dataValidator = dataValidator;
        this.reportCreator = reportCreator;
        this.reportWriter = reportWriter;
    }

    @Override
    public void createReport(String source, String destination) {
        List<String> inputData = fruitDao.get(source);
        dataValidator.validate(inputData);
        Map<String, Integer> fruitQuantityMap = fruitParser.parse(inputData);
        String reportContent = reportCreator.createReport(fruitQuantityMap);
        reportWriter.writeReport(destination, reportContent);

    }
}
