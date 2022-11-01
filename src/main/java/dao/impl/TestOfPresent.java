package dao.impl;

import dao.Containsoperation;
import db.Storage;

public class TestOfPresent implements Containsoperation {
    @Override
    public boolean isInStorage(String fruit) {
        return Storage.storage.containsKey(fruit);
    }
}
