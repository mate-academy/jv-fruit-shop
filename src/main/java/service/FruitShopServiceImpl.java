package service;

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
    public List<FruitDto> processingData() {
        List<FruitDto> fruitsFromFile = fruitShopRepoImpl.getFruitsFromFile();
        List<FruitDto> fruitsWithBalance = getFruitsWithBalanceType(fruitsFromFile);
        fruitsFromFile.removeAll(fruitsWithBalance);
        for (FruitDto fruitDto : fruitsFromFile) {
            String operationType = fruitDto.getTypeOfOperation();
            int value = fruitDto.getValue();
            for (FruitDto fruitDto1 : fruitsWithBalance) {
                if (fruitDto.getFruitName().equals(fruitDto1.getFruitName())) {
                    fruitDto1.setValue(parseTypeOfOperation(
                            operationType, value, fruitDto1.getValue()));
                }
            }
        }

        fruitShopRepoImpl.writeData(fruitsWithBalance);
        return fruitsFromFile;
    }

    private List<FruitDto> getFruitsWithBalanceType(List<FruitDto> fruitsFromFile) {
        return fruitsFromFile.stream()
                .filter(i -> i.getTypeOfOperation().equals("b"))
                .collect(Collectors.toList());
    }

    private int parseTypeOfOperation(String operationType, int value, int balance) {
        switch (operationType) {
            case "b":
                return balance;
            case "p":
                return balance - value;
            default:
                return balance + value;
        }
    }
}

