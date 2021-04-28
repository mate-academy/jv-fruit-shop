package core.basesyntax.model.dto;

public class FruitDataDto {
    private String operationType;
    private String fruitName;
    private Integer fruitQuantity;

    public FruitDataDto(String operationType, String fruitName, Integer fruitQuantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.fruitQuantity = fruitQuantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getFruitQuantity() {
        return fruitQuantity;
    }

    public enum Operations {
        b, s, p, r;

        public static boolean contains(String inputOperation) {
            for (Operations operation : Operations.values()) {
                if (operation.name().equals(inputOperation)) {
                    return true;
                }
            }
            return false;
        }
    }
}
