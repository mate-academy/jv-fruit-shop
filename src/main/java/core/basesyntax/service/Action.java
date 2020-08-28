package core.basesyntax.service;

import core.basesyntax.handler.Request;

public interface Action {

    void execute(Request request);

}
