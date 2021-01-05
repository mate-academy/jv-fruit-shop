package core.basesyntax.service;

import java.util.Arrays;

public enum Procedure {
    Balance("b"),
    Supply("s"),
    Purchase("p"),
    Return("r");

    private String procedure;

    Procedure(String procedure) {
        this.procedure = procedure;
    }

    public String getProcedure() {
        return procedure;
    }

    public static Procedure findByProcedure(String latter) {
        return Arrays.stream(Procedure.values())
                .filter(x -> x.getProcedure()
                        .equals(latter)).findFirst().get();
    }

}
