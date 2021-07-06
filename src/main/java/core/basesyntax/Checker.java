package core.basesyntax;

public class Checker {
    public boolean checkIfStringIsNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
