package fruitsassortment;

public enum ListOfFruits {
    BANANA,
    APPLE;

    public static boolean contains(String name) {
        for (ListOfFruits fruitName : ListOfFruits.values()) {
            if (fruitName.toString().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
