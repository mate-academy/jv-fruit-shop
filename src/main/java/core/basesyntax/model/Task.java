package core.basesyntax.model;

public class Task {
    private ActionType type;
    private String labelGoods;
    private int value;

    public Task(ActionType type, String labelGoods, int value) {
        this.type = type;
        this.labelGoods = labelGoods;
        this.value = value;
    }

    public ActionType getType() {
        return type;
    }

    public String getLabelGoods() {
        return labelGoods;
    }

    public int getValue() {
        return value;
    }

    public enum ActionType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        ActionType(String code) {
            this.code = code;
        }

        public String getType() {
            return code;
        }
    }
}
