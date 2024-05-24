package core.basesyntax.model;

public enum FruitModel {
    BANANA("banana"),
    APPLE(("apple")),
    LIME("lime"),
    PEACH("peach"),
    PINEAPPLE("pineapple");

    private final String code;

    FruitModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static FruitModel getModelFromCode(String code) {
        for (FruitModel model : FruitModel.values()) {
            if (model.getCode().equals(code)) {
                return model;
            }
        }
        throw new RuntimeException("Invalid operation type " + code);
    }
}

