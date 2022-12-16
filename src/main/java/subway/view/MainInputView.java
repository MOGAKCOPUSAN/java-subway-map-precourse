package subway.view;

import subway.util.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainInputView {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final String MAIN_INPUT_MESSAGE = "## 메인 화면";
    public static final String MAIN_FIRST_INPUT_MESSAGE = "1. 역 관리";
    public static final String MAIN_SECOND_INPUT_MESSAGE = "2. 노선 관리";
    public static final String MAIN_THIRD_INPUT_MESSAGE = "3. 구간 관리";
    public static final String MAIN_FOURTH_INPUT_MESSAGE = "4. 지하철 노선도 출력";
    public static final String MAIN_QUIT_INPUT_MESSAGE =  "Q. 종료";

    public static final String USER_CHOICE_INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";

    public String getMainChoice() throws IOException {
        printMainChoiceMessage();
        printMessage(USER_CHOICE_INPUT_MESSAGE);
        String choice = reader.readLine();
        InputValidator.checkChoice(Arrays.asList("1", "2", "3", "4", "Q"), choice);
        return choice;
    }

    private void printMainChoiceMessage() {
        printMessage(MAIN_INPUT_MESSAGE);
        printMessage(MAIN_FIRST_INPUT_MESSAGE);
        printMessage(MAIN_SECOND_INPUT_MESSAGE);
        printMessage(MAIN_THIRD_INPUT_MESSAGE);
        printMessage(MAIN_FOURTH_INPUT_MESSAGE);
        printMessage(MAIN_QUIT_INPUT_MESSAGE);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
