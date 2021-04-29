package core.basesyntax.service.storageservice;

import core.basesyntax.model.dto.TransactionDto;
import java.util.List;

public interface StorageService {
    void addToStorage(List<TransactionDto> transactionDataEntities);

    String getReport();
}
