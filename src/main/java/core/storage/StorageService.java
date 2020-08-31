package core.storage;

import core.exceptions.NoFruitsEnoughException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StorageService{
    private Map<FruitPackageDTO, Integer> fruitBay;
    private Set<String> operators;

    public StorageService() {
        Set<String> operators = new HashSet<>();
        operators.add("s");
        operators.add("r");
        operators.add("b");
        this.operators = operators;
        this.fruitBay = new HashMap();
    }

    public boolean addToStorage(FruitPackageDTO fruitPackageDTO, Integer quantity) {
        fruitBay.put(fruitPackageDTO, quantity);
        return true;
    }

    public boolean removeFromStorage(FruitPackageDTO fruitPackageDTO, int quantity) {
        check(fruitPackageDTO, quantity);
        fruitBay.put(fruitPackageDTO, (fruitBay.get(fruitPackageDTO) - quantity));
        return true;
    }

    public List<String> getRemainingFruit() {
        List<String> list = new ArrayList<>();
        Set<FruitPackageDTO> fruitPackageDTOS = fruitBay.keySet();
        for (FruitPackageDTO fruitPackageDTO : fruitPackageDTOS) {
            list.add(fruitPackageDTO.getFruitType() + "," + fruitBay.get(fruitPackageDTO));
        }
        return list;
    }

    public Integer getFruitQuantity(FruitPackageDTO fruit) {
        return fruitBay.get(fruit);
    }

    private void check(FruitPackageDTO fruitPackageDTO, int quantity) {
        int has = getFruitQuantity(fruitPackageDTO);
        if (has < quantity) {
            Throwable RuntimeException = new Throwable();
            throw new NoFruitsEnoughException("Sorry, trying to buy " + quantity
                    + " " + fruitPackageDTO.getFruitType() + ", but have only " + has, RuntimeException);
        }
    }
}
