package shopoperations;

public enum ListOfOperations {
    B,
    S,
    P,
    R;

    public static boolean contains(String value) {
        for (ListOfOperations operation : ListOfOperations.values()) {
            if (operation.toString().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
