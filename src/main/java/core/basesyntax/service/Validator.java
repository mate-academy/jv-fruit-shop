package core.basesyntax.service;

public class Validator {

    public boolean validateRow(String row) {
        if (row.split(",").length != 3) {
            return false;
        }
        return true;
    }
}
