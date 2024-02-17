package core.basesyntax.db;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import core.basesyntax.service.ShopServiceStrategy;

public class Storage {
    public static final List<File> list = new ArrayList<>();

    public static final Map<ShopServiceStrategy.Operation, Integer> foodStorage = new HashMap<>();
}
