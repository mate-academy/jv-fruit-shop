package model;

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
