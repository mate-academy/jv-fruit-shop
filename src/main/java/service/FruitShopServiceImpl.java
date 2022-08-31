package service;

import static service.OperationType.BALANCE;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitDto;
import storage.FruitShopRepo;

public class FruitShopServiceImpl implements FruitShopService {
    private final FruitShopRepo fruitShopRepoImpl;

    public FruitShopServiceImpl(FruitShopRepo fruitShopRepoImpl) {
        this.fruitShopRepoImpl = fruitShopRepoImpl;
    }

    @Override
    public File processingData(File file) {
        List<FruitDto> fruitsFromFile = fruitShopRepoImpl.getFruitsFromFile(file);
        List<FruitDto> fruitsWithBalance = getFruitsWithBalanceType(fruitsFromFile);
        fruitsFromFile.removeAll(fruitsWithBalance);
        for (FruitDto fruitDto : fruitsFromFile) {
            OperationType operationType = fruitDto.getTypeOfOperation();
            int value = fruitDto.getValue();
            for (FruitDto fruit : fruitsWithBalance) {
                if (fruitDto.getFruitName().equals(fruit.getFruitName())) {
                    fruit.setValue(parseTypeOfOperation(
                            operationType, value, fruit.getValue()));
                }
            }
        }


        return fruitShopRepoImpl.writeData(fruitsWithBalance);
    }

    private List<FruitDto> getFruitsWithBalanceType(List<FruitDto> fruitsFromFile) {
        return fruitsFromFile.stream()
                .filter(i -> i.getTypeOfOperation().equals(BALANCE))
                .collect(Collectors.toList());
    }

    private int parseTypeOfOperation(OperationType operationType, int value, int balance) {
        switch (operationType) {
            case BALANCE:
                return balance;
            case PURCHASE:
                return balance - value;
            default:
                return balance + value;
        }
    }
}

