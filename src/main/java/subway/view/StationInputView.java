package subway.view;

import subway.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class StationInputView {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final String STATION_INPUT_MESSAGE = "## 역 관리 화면";
    public static final String STATION_FIRST_INPUT_MESSAGE = "1. 역 등록";
    public static final String STATION_SECOND_INPUT_MESSAGE = "2. 역 삭제";
    public static final String STATION_THIRD_INPUT_MESSAGE = "3. 역 조회";
    public static final String STATION_QUIT_INPUT_MESSAGE = "B. 돌아가기";

    public static final String USER_CHOICE_INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String STATION_REGISTER_INPUT_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    public static final String STATION_DELETE_INPUT_MESSAGE = "## 삭제할 역 이름을 입력하세요.";

    public String getStationManageChoice() throws IOException {
        printStationManageChoiceMessage();
        printMessage(USER_CHOICE_INPUT_MESSAGE);
        String choice = reader.readLine();
        InputValidator.checkChoice(Arrays.asList("1", "2", "3", "B"), choice);
        return choice;
    }

    private void printStationManageChoiceMessage() {
        printMessage(STATION_INPUT_MESSAGE);
        printMessage(STATION_FIRST_INPUT_MESSAGE);
        printMessage(STATION_SECOND_INPUT_MESSAGE);
        printMessage(STATION_THIRD_INPUT_MESSAGE);
        printMessage(STATION_QUIT_INPUT_MESSAGE);
    }

    public String getResisterStationName() throws IOException {
        printMessage(STATION_REGISTER_INPUT_MESSAGE);
        String stationName = reader.readLine();
        InputValidator.checkKorean(stationName);
        return stationName;
    }

    public String getDeleteStationName() throws IOException {
        printMessage(STATION_DELETE_INPUT_MESSAGE);
        String stationName = reader.readLine();
        InputValidator.checkKorean(stationName);
        return stationName;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
