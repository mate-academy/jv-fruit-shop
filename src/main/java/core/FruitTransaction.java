package core;

public class FruitTransaction {
    private static final String BALANCE_OPERATION = "b";
    private static final String SUPPLY_OPERATION = "s";
    private static final String PURCHASE_OPERATION = "p";
    private static final String RETURN_OPERATION = "r";
    private Activity activity;
    private String fruit;
    private Integer count;

    public FruitTransaction(Activity activity, String fruit, Integer count) {
        this.activity = activity;
        this.fruit = fruit;
        this.count = count;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *     b - balance, the remnants of fruits at the beginning of the working day
     *     s - supply, means you are receiving new fruits from suppliers
     *     p - purchase, means someone has bought some fruit
     *     r - return, means someone who have bought the fruits now returns them back
     */
    public enum Activity {
        BALANCE(BALANCE_OPERATION),
        SUPPLY(SUPPLY_OPERATION),
        PURCHASE(PURCHASE_OPERATION),
        RETURN(RETURN_OPERATION);

        private String operation;

        Activity(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}
