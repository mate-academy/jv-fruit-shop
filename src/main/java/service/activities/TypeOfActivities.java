package service.activities;

public enum TypeOfActivities {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String activities;

    TypeOfActivities(String activities) {
        this.activities = activities;
    }

    public String getActivitiesValues() {
        return activities;
    }

    public TypeOfActivities getActivities(String value) {
        TypeOfActivities[] values = TypeOfActivities.values();
        for (TypeOfActivities type : values) {
            if (type.getActivitiesValues().equals(value)) {
                return type;
            }
        }
        throw new RuntimeException("Can't find type of activities with this value, " + value);
    }
}
