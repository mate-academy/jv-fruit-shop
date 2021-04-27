package core.basesyntax.service.works;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.validation.Validator;
import core.basesyntax.storage.Storage;
import java.util.List;

public class WorkWithStorageImpl implements WorkWithStorage {
    private static final String SEPARATOR = ",";
    private static final int TITLE_INDEX = 0;
    private static final String TITLE = "fruit,quantity";
    private Validator validator;
    private OperationStrategy strategy;

    public WorkWithStorageImpl(Validator validator, OperationStrategy strategy) {
        this.validator = validator;
        this.strategy = strategy;
    }

    @Override
    public void writeToStorage(List<String> information) {
        information.remove(TITLE_INDEX);
        information.forEach(validator::validateFile);
        Storage.getFruits().clear();
        information.forEach(this::fruitsDistribution);
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE).append(System.lineSeparator());
        Storage.getFruits().forEach((key, value) -> report.append(key).append(SEPARATOR)
                .append(value).append(System.lineSeparator()));
        report.setLength(report.length() - 1);
        return report.toString();
    }

    private void fruitsDistribution(String lineFromDb) {
        String[] fields = lineFromDb.split(SEPARATOR);
        strategy.get(fields[0]).fruitActivity(fields[1], Integer.parseInt(fields[2]));
    }
}
