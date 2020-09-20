package core.storage;

import jdk.dynalink.Operation;

import java.time.LocalDate;

public class FruitPackageDTO {
    private String fruitType;
    private int size;
    private LocalDate expireDate;

    public FruitPackageDTO(String fruitType, LocalDate expireDate) {
        this.fruitType = fruitType;
        this.expireDate = expireDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }
}
