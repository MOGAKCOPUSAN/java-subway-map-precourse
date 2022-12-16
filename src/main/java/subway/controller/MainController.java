package subway.controller;

import java.util.Map;
import subway.Constants;

public class MainController extends Controller{

    Map<String, Controller> menuMap = Map.of(
        Constants.INPUT_STATION_MANAGEMENT, new StationController(),
        Constants.INPUT_LINE_MANAGEMENT, new LineController(),
        Constants.INPUT_SECTION_MANAGEMENT, new SectionController(),
        Constants.INPUT_SUBWAY_PRINT, new ResultController());

    @Override
    public void run() {
        String mainNumber;
        do {
            mainNumber = inputView.readMainNumber();
            try {
                menuMap.get(mainNumber).run();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        } while (!mainNumber.equals(Constants.INPUT_QUIT));
    }

}
