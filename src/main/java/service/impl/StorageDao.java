package service.impl;

import interfaces.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageDao implements Storage {
    public static final Map<String, Integer> storage = new HashMap<>();
}
