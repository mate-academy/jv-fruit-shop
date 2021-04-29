package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.validation.Validator;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String SEPARATOR = ",";
    private static final int TITLE_INDEX = 0;
    private static final String TITLE = "fruit,quantity";
    private Validator validator;
    private OperationStrategy strategy;
    private FruitDao fruitDao;

    public FruitServiceImpl(Validator validator, OperationStrategy strategy, FruitDao fruitDao) {
        this.validator = validator;
        this.strategy = strategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void writeToStorage(List<String> information) {
        information.remove(TITLE_INDEX);
        information.forEach(validator::validateFile);
        fruitDao.clearStorage();
        information.forEach(this::doFruitActivities);
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE).append(System.lineSeparator());
        fruitDao.getAll().forEach((key, value) -> report.append(key).append(SEPARATOR)
                .append(value).append(System.lineSeparator()));
        report.setLength(report.length() - 1);
        return report.toString();
    }

    private void doFruitActivities(String lineFromDb) {
        String[] fields = lineFromDb.split(SEPARATOR);
        strategy.get(fields[0])
                .doOperationWithFruit(new FruitDto(fields[1], Integer.parseInt(fields[2])));
    }
}
