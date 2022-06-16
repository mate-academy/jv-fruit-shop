package core.basesyntax;

import core.basesyntax.service.GetBalancePerDay;

public class Main {

    public static void main(String[] args) {
        GetBalancePerDay getBalancePerDay = new GetBalancePerDay();
        getBalancePerDay.getBalance();
    }
}
