package service.impl;

import java.util.HashMap;
import strategy.FruitStrategy;
import strategy.Strategy;

public class CsvDataCollector {
    //Додає в Inventory.invettoryMap інформацію про операції, відповідно до їх типу,
    //використовуючи Strategy
    Strategy strategy = new Strategy(new HashMap<String, FruitStrategy>());

}
