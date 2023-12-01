package core.basesyntax.processTransactionService;

import core.basesyntax.db.Storage;

public class ReportListFruitServiceImpl implements ReportListFruitService {
    private static final String DELIMITER = ",";
    private static final String FILE_HEADER = "fruit,quantity";
    private Storage storage;

    public ReportListFruitServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(FILE_HEADER).append(System.lineSeparator())
                .append(storage.getFruitStorage().entrySet().stream()
                            .map(key -> key.getKey() + DELIMITER + key.getValue()));
        return builder.toString();
    }
}
