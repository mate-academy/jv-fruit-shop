package core.basesyntax.model;

public class Account {
    private int bananaBalance = 0;
    private int appleBalance = 0;

    public void setAppleBalance(int appleBalance) {
        this.appleBalance = appleBalance;
    }

    public void setBananaBalance(int bananaBalance) {
        this.bananaBalance = bananaBalance;
    }

    public int getBananaBalance() {
        return bananaBalance;
    }

    public int getAppleBalance() {
        return appleBalance;
    }

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
    }
}
