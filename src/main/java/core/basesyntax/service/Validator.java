package core.basesyntax.service;

public class Validator {

    public boolean validateRow(String row) {
        String[] arrActivityInform = row.split(",");
        if (arrActivityInform.length != 3) {
            return false;
        }
        return true;
    }
}
