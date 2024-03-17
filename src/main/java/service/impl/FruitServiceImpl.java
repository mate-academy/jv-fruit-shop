package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.FruitService;
import strategy.FruitStrategy;
import strategy.FruitStrategyImpl;
import strategy.handlers.StrategyHandler;

import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {

    Storage storage = new Storage();
    private final Map<List<FruitTransaction>, FruitStrategy> strategies;

    public FruitServiceImpl(Map<List<FruitTransaction>, FruitStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public void processTransaction(Map<List<FruitTransaction>, FruitStrategy> activities) {
        List<FruitTransaction> transactions = storage.getTransactions();
        FruitStrategy fruitStrategy = new FruitStrategyImpl();
        }
    }
