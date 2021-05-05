package core.basesyntax.model;

public enum Operation {
    b,
    r,
    s,
    p;

    public static boolean isPresent(String value){
        Operation [] operations = values();
        for(Operation operation: operations) {
            if (operation.toString().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
