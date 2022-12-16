package subway.controller;

import subway.repository.LineRepository;
import subway.service.InitService;
import subway.util.Log;
import subway.view.*;

import java.io.IOException;


public class SubwayController {

    public static final String STATION_MANAGE = "1";
    public static final String LINE_MANAGE = "2";
    public static final String SECTION_MANAGE = "3";
    public static final String SUBWAY_LINE_MANAGE = "4";
    public static final String QUIT = "Q";

    private final MainInputView mainInputView = new MainInputView();
    private final StationController stationController = new StationController();
    private final LineController lineController = new LineController();
    private final SectionController sectionController = new SectionController();
    private final InitService initService = new InitService();
    private final OutputView outputView = new OutputView();

    public void run() {
        initService.init();
        String userChoice;
        do{
            userChoice = getMainUserChoice();
            start(userChoice);
        } while (canContinue(userChoice));
    }

    private boolean canContinue(String userChoice) {
        return !userChoice.equals(QUIT);
    }

    private void start(String userChoice) {
        if (userChoice.equals(STATION_MANAGE)) {
            stationController.run();
        }
        if (userChoice.equals(LINE_MANAGE)) {
            lineController.run();
        }
        if (userChoice.equals(SECTION_MANAGE)) {
            sectionController.run();
        }
        if (userChoice.equals(SUBWAY_LINE_MANAGE)) {
            outputView.shoeLineAndStation(LineRepository.lines());
        }
    }

    public String getMainUserChoice() {
        try {
            return mainInputView.getMainChoice();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getMainUserChoice();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getMainUserChoice();
        }
    }
}
