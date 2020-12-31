package core.activities;

public class ReturnActivitiesHandler implements ActivitiesHandler {
    @Override
    public int getAmountOfFruits(int fruitsInShop, int fruitsInCirculation) {
        if (fruitsInCirculation < 0) {
            throw new RuntimeException("Buyers can't return negative value of fruits!");
        }
        return fruitsInShop + fruitsInCirculation;
    }
}
