package subway.controller;

import subway.service.LineService;
import subway.util.Log;
import subway.view.LineInputView;
import subway.view.OutputView;

import java.io.IOException;

public class LineController {

    public static final String LINE_REGISTER = "1";
    public static final String LINE_DELETE = "2";
    public static final String LINE_INQUIRY = "3";
    public static final String BACK = "B";

    private final LineInputView lineInputView = new LineInputView();
    private final LineService lineService = new LineService();
    private final OutputView outputView = new OutputView();

    private void register() {
        String lineName = getRegisterLineName();
        String upperStation = getUpperStation();
        String lowerStation = getLowerStation();
        try {
            lineService.add(lineName, upperStation, lowerStation);
            outputView.showLineRegisterResultMessage();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
        }
    }

    private String getRegisterLineName() {
        try {
            String lineName = lineInputView.getRegisterLineName();
            return lineName;
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getRegisterLineName();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getRegisterLineName();
        }
    }

    private String getUpperStation() {
        try {
            String stationName = lineInputView.getUpperStation();
            return stationName;
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getUpperStation();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getUpperStation();
        }
    }

    private String getLowerStation() {
        try {
            String stationName = lineInputView.getLowerStation();
            return stationName;
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getLowerStation();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getLowerStation();
        }
    }

    private String getDeleteLineName() {
        try {
            String lineName = lineInputView.getDeleteLineName();
            return lineName;
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getDeleteLineName();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getDeleteLineName();
        }
    }

    private String getUserChoice() {
        try {
            return lineInputView.getLineManageChoice();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getUserChoice();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getUserChoice();
        }
    }
}
