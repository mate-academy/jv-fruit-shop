package core.basesyntax.service.storageservice;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.dto.TransactionDto;
import core.basesyntax.model.product.Fruit;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String SPLITTER = ",";
    private final OperationStrategy operationStrategy;
    private final StorageDao storageDao;

    public StorageServiceImpl(OperationStrategy operationStrategy, StorageDao storageDao) {
        this.operationStrategy = operationStrategy;
        this.storageDao = storageDao;
    }

    @Override
    public void addToStorage(List<TransactionDto> transactionDtos) {
        for (TransactionDto entity : transactionDtos) {
            operationStrategy.getHandler(entity.getOperation())
                    .apply(entity.getFruit(), entity.getAmount());
        }
    }

    @Override
    public String getReport() {
        StringBuilder stringReport = new StringBuilder(TITLE);
        for (Map.Entry<Fruit, Integer> entry : storageDao.getAll().entrySet()) {
            stringReport.append(entry.getKey().getName())
                    .append(SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringReport.toString();
    }
}
