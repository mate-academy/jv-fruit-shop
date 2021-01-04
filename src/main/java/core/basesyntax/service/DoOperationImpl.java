package core.basesyntax.service;

import core.basesyntax.service.operations.Operation;

import java.util.Map;

public class DoOperationImpl implements DoOperation{
    @Override
    public void doOperation(Map<String, Integer> shop, String operation, String key, String value) {
        Map<String, Operation> operations = new PrepareMapImpl().prepareMap();
        shop.put(key, operations.get(operation).operation(shop.get(key), Integer.parseInt(value)));
    }
}