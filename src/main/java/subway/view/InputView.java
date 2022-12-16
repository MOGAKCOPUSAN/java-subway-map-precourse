package subway.view;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import subway.Constants;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Set<String> MAIN_NUMBERS = Set.of(Constants.INPUT_STATION_MANAGEMENT,
        Constants.INPUT_LINE_MANAGEMENT, Constants.INPUT_SECTION_MANAGEMENT,
        Constants.INPUT_SUBWAY_PRINT, Constants.INPUT_QUIT);


    public String readMainNumber() {
        System.out.println("## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료");
        printInputMessage();
        String input = scanner.nextLine();
        validateMainNumber(input);
        return input;
    }

    private void printInputMessage() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    private void validateMainNumber(String input) {
        if (!MAIN_NUMBERS.contains(input)) {
            throw new IllegalArgumentException("잘못된 기능 번호입니다.");
        }
    }
}
