package service;

public interface Strategy {
    OperationHandler getActivity(String storeActivityType);
}
