package storage;

import java.util.List;
import model.TransactionDto;

public class StorageTransactions {
    private List<TransactionDto> storage;

    public StorageTransactions(List<TransactionDto> storage) {
        this.storage = storage;
    }

    public List<TransactionDto> getStorage() {
        return storage;
    }

    public void setStorage(List<TransactionDto> storage) {
        this.storage = storage;
    }
}
