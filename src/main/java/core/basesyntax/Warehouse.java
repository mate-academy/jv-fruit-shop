package core.basesyntax;

public class Warehouse {
    private int bananaQuantity;
    private int appleQuantity;
    private final char BANANA = 'b';
    private final char APPLE = 'a';

    Warehouse (int bananaQuantity, int appleQuantity) {
        this.bananaQuantity = bananaQuantity;
        this.appleQuantity = appleQuantity;
    }

    public int getBananaQuantity() {
        return bananaQuantity;
    }

    public void setBananaQuantity(int bananaQuantity) {
        this.bananaQuantity = bananaQuantity;
    }

    public int getAppleQuantity() {
        return appleQuantity;
    }

    public void setAppleQuantity(int appleQuantity) {
        this.appleQuantity = appleQuantity;
    }

    public boolean consumptionBanana (int quantity) {
        if (isEnough(quantity, BANANA)) {
           bananaQuantity -= quantity;
           return true;
        }
        return false;
    }

    public boolean consumptionAPPLE (int quantity) {
        if (isEnough(quantity, APPLE)) {
            appleQuantity -= quantity;
            return true;
        }
        return false;
    }

    private boolean isEnough(int quantity, char c) {
        switch (c) {
            case ('a'):
                return appleQuantity - quantity >= 0;
            case ('b'):
                return bananaQuantity - quantity >= 0;
            default: throw (new RuntimeException("wrong char"));
        }
    }
}
