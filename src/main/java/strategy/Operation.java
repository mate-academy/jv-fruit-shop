package strategy;

import db.StorageService;

public interface Operation {

    void execute(StorageService storage, String fruit, int quantity);
}
