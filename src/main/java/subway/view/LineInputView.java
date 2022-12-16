package subway.view;

import subway.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LineInputView {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final String LINE_INPUT_MESSAGE = "## 노선 관리 화면";
    public static final String LINE_FIRST_INPUT_MESSAGE = "1. 노선 등록";
    public static final String LINE_SECOND_INPUT_MESSAGE = "2. 노선 삭제";
    public static final String LINE_THIRD_INPUT_MESSAGE = "3. 노선 조회";
    public static final String LINE_QUIT_INPUT_MESSAGE = "B. 돌아가기";

    public static final String USER_CHOICE_INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String LINE_REGISTER_INPUT_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    public static final String LINE_UPPER_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String LINE_LOWER_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String LINE_DELETE_INPUT_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";

    public String getLineManageChoice() throws IOException {
        printLineManageChoiceMessage();
        printMessage(USER_CHOICE_INPUT_MESSAGE);
        String choice = reader.readLine();
        InputValidator.checkChoice(Arrays.asList("1", "2", "3", "B"), choice);
        return choice;
    }

    private void printLineManageChoiceMessage() {
        printMessage(LINE_INPUT_MESSAGE);
        printMessage(LINE_FIRST_INPUT_MESSAGE);
        printMessage(LINE_SECOND_INPUT_MESSAGE);
        printMessage(LINE_THIRD_INPUT_MESSAGE);
        printMessage(LINE_QUIT_INPUT_MESSAGE);
    }

    public String getRegisterLineName() throws IOException {
        printMessage(LINE_REGISTER_INPUT_MESSAGE);
        String lineName = reader.readLine();
        InputValidator.checkLineAndStation(lineName);
        return lineName;
    }

    public String getUpperStation() throws IOException {
        printMessage(LINE_UPPER_STATION_MESSAGE);
        String stationName = reader.readLine();
        InputValidator.checkLineAndStation(stationName);
        return stationName;
    }

    public String getLowerStation() throws IOException {
        printMessage(LINE_LOWER_STATION_MESSAGE);
        String stationName = reader.readLine();
        InputValidator.checkLineAndStation(stationName);
        return stationName;
    }

    public String getDeleteLineName() throws IOException {
        printMessage(LINE_DELETE_INPUT_MESSAGE);
        String lineName = reader.readLine();
        InputValidator.checkLineAndStation(lineName);
        return lineName;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
