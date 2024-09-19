package core.basesyntax.model;

public class FruitTransaction {
    private Action action;
    private String fruit;
    private int value;

    public FruitTransaction(Action action, String fruit, int value) {
        this.action = action;
        this.fruit = fruit;
        this.value = value;
    }

    public Action getAction() {
        return action;
    }

    public void setType(Action action) {
        this.action = action;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public enum Action {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Action(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Action fromCode(String code) {
            for (Action action : values()) {
                if (action.getCode().equals(code)) {
                    return action;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + code);
        }
    }
}
