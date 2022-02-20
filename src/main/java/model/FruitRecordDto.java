package model;

import java.util.Objects;

public class FruitRecordDto {
    private Activities type;
    private String fruit;
    private int amount;

    public FruitRecordDto() {
    }

    public Activities getType() {
        return type;
    }

    public void setType(Activities type) {
        this.type = type;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object modelDto) {
        if (this == modelDto) return true;
        if (modelDto == null || getClass() != modelDto.getClass()) return false;
        FruitRecordDto current = (FruitRecordDto) modelDto;
        return amount == current.amount && type == current.type && Objects.equals(fruit, current.fruit);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (type.hashCode() == 0 ? 0 : type.hashCode());
        result = 31 * result + (fruit.hashCode() == 0? 0 : fruit.hashCode());
        result = 31 * result + amount;
        return result;
    }

    public enum Activities {
        BALANCE("b"),
        SUPPLY("s"),
        RETURN("r"),
        PURCHASE("p");

        private final String label;

        Activities(String label) {
            this.label = label;
        }

        public static Activities valueOfLabel(String label) {
            for (Activities tepmEnum : values()) {
                if (tepmEnum.label.equals(label)) {
                    return tepmEnum;
                }
            }
            return null;
        }
    }
}
