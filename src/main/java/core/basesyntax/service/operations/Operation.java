package core.basesyntax.service.operations;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    private final String operationTitle;

    Operation(String operationTitle) {
        this.operationTitle = operationTitle;
    }

    public static Operation getEnumByTitle(String s) {
      switch (s){
          case "b":
              return BALANCE;
          case "p":
              return PURCHASE;
          case "r":
              return RETURN;
          case "s":
              return SUPPLY;
          default:
              throw new RuntimeException("Unknown operation: " + s);
      }
    }

    public String getOperationTitle() {
        return operationTitle;
    }
}
