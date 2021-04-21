package core.basesyntax.model;

import java.util.List;

public class Report {
    private String title;
    private List<Fruit> fruits;

    public Report(String title, List<Fruit> fruits) {
        this.title = title;
        this.fruits = fruits;
    }

    public String getTitle() {
        return title;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }
}
