package dao;

import database.Storage;
import exception.InvalidDataException;
import model.FruitTransaction;
import service.FruitService;

public class FruitDaoImpl implements FruitDao {
    private FruitService fruitService;

    public FruitDaoImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public FruitTransaction add(FruitTransaction fruitTransaction) {
        FruitTransaction newFruitTransaction = fruitService.createNewFruit(
                fruitTransaction.getName(), fruitTransaction.getQuantity());
        Storage.FRUIT_DTOS.add(newFruitTransaction);
        return newFruitTransaction;
    }

    @Override
    public FruitTransaction get(FruitTransaction fruitTransaction) {
        for (FruitTransaction fruitTransactionFromStorage : Storage.FRUIT_DTOS) {
            if (fruitTransactionFromStorage.getName().equals(fruitTransaction.getName())) {
                return fruitTransactionFromStorage;
            }
        }
        throw new InvalidDataException(
                "There is no fruit with name: " + fruitTransaction.getName());
    }
}

