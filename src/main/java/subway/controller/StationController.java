package subway.controller;

import subway.service.StationService;
import subway.util.Log;
import subway.view.OutputView;
import subway.view.StationInputView;

import java.io.IOException;

public class StationController {

    public static final String STATION_REGISTER = "1";
    public static final String STATION_DELETE = "2";
    public static final String STATION_INQUIRY = "3";
    public static final String BACK = "B";

    private final StationInputView stationInputView = new StationInputView();
    private final StationService stationService = new StationService();
    private final OutputView outputView = new OutputView();

    public void run() {
        String userChoice = getUserChoice();
        start(userChoice);
    }

    private void start(String userChoice) {
        if (userChoice.equals(STATION_REGISTER)) {
            register();
        }
        if (userChoice.equals(STATION_DELETE)) {
            delete();
        }
        if (userChoice.equals(STATION_INQUIRY)) {
            findAll();
        }
        if (userChoice.equals(BACK)) {
            return;
        }
    }

    private void findAll() {
        outputView.showStations(stationService.getStations());
    }


    private void delete() {
        String stationName = getUserStationName();
        try {
            stationService.delete(stationName);
            outputView.showStationDeleteResultMessage();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
        }
    }

    private void register() {
        String stationName = getUserStationName();
        try{
            stationService.add(stationName);
            outputView.showStationRegisterResultMessage();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
        }
    }

    private String getUserStationName() {
        try {
            return stationInputView.getResisterStationName();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getUserStationName();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getUserChoice();
        }
    }

    private String getUserChoice() {
        try {
            return stationInputView.getStationManageChoice();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getUserChoice();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getUserChoice();
        }
    }
}
