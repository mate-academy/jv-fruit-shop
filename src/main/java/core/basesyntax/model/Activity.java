package core.basesyntax.model;

public class Activity {
    private ActivityType activityType;
    private Fruits fruits;

    public Activity(Builder builder) {
        this.activityType = builder.activityType;
        this.fruits = builder.fruits;
    }

    public static class Builder {
        private ActivityType activityType;
        private Fruits fruits;

        public Builder setActivityType(ActivityType activityType) {
            this.activityType = activityType;
            return this;
        }

        public Builder setFruit(Fruits fruits) {
            this.fruits = fruits;
            return this;
        }

        public Activity build() {
            return new Activity(this);
        }

    }


    public Fruits getFruit() {
        return fruits;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityType=" + activityType +
                ", fruits=" + fruits +
                '}' + System.lineSeparator();
    }
}
