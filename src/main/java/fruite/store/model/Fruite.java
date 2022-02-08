package fruite.store.model;

public enum Fruite {
    BANANA ("banana"),
    APPLE ("apple");

    private String fruite;

    Fruite(String fruite) {
        this.fruite = fruite;
    }

    public String getFruite() {
        return fruite;
    }
}
