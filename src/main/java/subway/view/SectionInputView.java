package subway.view;

import subway.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SectionInputView {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final String SECTION_INPUT_MESSAGE = "## 구간 관리 화면";
    public static final String SECTION_FIRST_INPUT_MESSAGE = "1. 구간 등록";
    public static final String SECTION_SECOND_INPUT_MESSAGE = "2. 구간 삭제";
    public static final String SECTION_QUIT_INPUT_MESSAGE = "B. 돌아가기";

    public static final String USER_CHOICE_INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String SECTION_LINE_CHOICE_MESSAGE = "## 노선을 입력하세요.";
    public static final String SECTION_STATION_CHOICE_MESSAGE = "## 역이름을 입력하세요.";
    public static final String SECTION_INDEX_CHOICE_MESSAGE = "## 순서를 입력하세요.";

    public static final String SECTION_DELETE_LINE_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String SECTION_DELETE_STATION_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";

    public String getSectionManageChoice() throws IOException {
        printSectionManageChoiceMessage();
        printMessage(USER_CHOICE_INPUT_MESSAGE);
        String choice = reader.readLine();
        InputValidator.checkChoice(Arrays.asList("1", "2", "B"), choice);
        return choice;
    }

    private void printSectionManageChoiceMessage() {
        printMessage(SECTION_INPUT_MESSAGE);
        printMessage(SECTION_FIRST_INPUT_MESSAGE);
        printMessage(SECTION_SECOND_INPUT_MESSAGE);
        printMessage(SECTION_QUIT_INPUT_MESSAGE);
    }

    public String getRegisterSectionLine() throws IOException {
        printMessage(SECTION_LINE_CHOICE_MESSAGE);
        return getSectionLine();
    }

    public String getRegisterSectionStation() throws IOException {
        printMessage(SECTION_STATION_CHOICE_MESSAGE);
        return getSectionStation();
    }

    public String getDeleteSectionLine() throws IOException {
        printMessage(SECTION_DELETE_LINE_MESSAGE);
        return getSectionLine();
    }

    public String getDeleteSectionStation() throws IOException {
        printMessage(SECTION_DELETE_STATION_MESSAGE);
        return getSectionStation();
    }

    public String getSectionLine() throws IOException {
        String lineName = reader.readLine();
        InputValidator.checkKorean(lineName);
        return lineName;
    }

    public String getSectionStation() throws IOException {
        String stationName = reader.readLine();
        InputValidator.checkKorean(stationName);
        return stationName;
    }

    public int getSectionIndex() throws IOException {
        printMessage(SECTION_INDEX_CHOICE_MESSAGE);
        String index = reader.readLine();
        InputValidator.checkDigit(index);
        return Integer.valueOf(index);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
