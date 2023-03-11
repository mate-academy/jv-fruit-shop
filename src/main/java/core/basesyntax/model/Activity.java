package core.basesyntax.model;

public class Activity {
    private ActivityType activityType;
    private Fruit fruit;
    private int quantity;

    private Activity(Builder builder) {
        this.activityType = builder.activityType;
        this.fruit = builder.fruit;
        this.quantity = builder.quantity;
    }

    public static class Builder {
        private ActivityType activityType;
        private Fruit fruit;
        private int quantity;

        public Builder setActivityType(ActivityType activityType) {
            this.activityType = activityType;
            return this;
        }

        public Builder setFruit(Fruit fruit) {
            this.fruit = fruit;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Activity build() {
            return new Activity(this);
        }

    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Activity{"
                + "activityType=" + activityType
                + ", fruit=" + fruit
                + ", quantity=" + quantity
                + '}';
    }
}
