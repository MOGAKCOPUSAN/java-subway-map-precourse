package subway.controller;

import java.util.function.Supplier;
import subway.view.InputView;
import subway.view.OutputView;

public abstract class Controller {
    protected static final InputView inputView = new InputView();
    protected static final OutputView outputView = new OutputView();

    public <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }

    public abstract void run();
}
