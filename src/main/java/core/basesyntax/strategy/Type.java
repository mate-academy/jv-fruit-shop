package core.basesyntax.strategy;

public enum Type {
    Balance('b'),
    Supply('s'),
    Purchase('p'),
    Return('r');
    private final char charValue;

    Type(char charValue) {
        this.charValue = charValue;
    }

    public char getCharValue() {
        return charValue;
    }

}
