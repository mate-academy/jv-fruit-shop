package core.basesyntax;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    // Конструктор за замовчуванням (важливо для деяких фреймворків)
    public FruitTransaction() {
    }

    // Зручний конструктор для ініціалізації
    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    // ENUM для операцій — це робить код безпечним (ти не зможеш передати "error" замість "b")
    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        // Статичний метод, щоб знайти операцію за буквою з CSV (наприклад, "b")
        public static Operation fromCode(String code) {
            for (Operation op : Operation.values()) {
                if (op.code.equals(code)) {
                    return op;
                }
            }
            throw new RuntimeException("Unknown operation code: " + code);
        }
    }

    // Гетери та сетери
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
