package subway.view;

import java.util.Scanner;
import java.util.Set;
import subway.Constants;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Set<String> MAIN_NUMBERS = Set.of(Constants.INPUT_STATION_MANAGEMENT,
        Constants.INPUT_LINE_MANAGEMENT, Constants.INPUT_SECTION_MANAGEMENT,
        Constants.INPUT_SUBWAY_PRINT, Constants.INPUT_QUIT);

    private static final Set<String> STATION_LINE_NUMBERS = Set.of(Constants.INPUT_REGISTRATION,
        Constants.INPUT_DELETE, Constants.INPUT_SEARCH, Constants.INPUT_BACK);

    private static final Set<String> SECTION_NUMBERS = Set.of(Constants.INPUT_REGISTRATION,
        Constants.INPUT_DELETE, Constants.INPUT_BACK);
    public static final int MIN_NAME_LENGTH = 2;

    public String readMainNumber() {
        System.out.println("## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료");
        printFeatureMessage();
        String input = scanner.nextLine();
        validateMainNumber(input);
        return input;
    }

    private void printFeatureMessage() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    private void validateMainNumber(String input) {
        if (!MAIN_NUMBERS.contains(input)) {
            throw new IllegalArgumentException("잘못된 기능 번호입니다.");
        }
    }

    public String readStationNumber() {
        System.out.println("## 역 관리 화면\n"
            + "1. 역 등록\n"
            + "2. 역 삭제\n"
            + "3. 역 조회\n"
            + "B. 돌아가기");
        printFeatureMessage();
        String input = scanner.nextLine();
        validateStationAndLineNumber(input);
        return input;
    }

    private void validateStationAndLineNumber(String input) {
        if (!STATION_LINE_NUMBERS.contains(input)) {
            throw new IllegalArgumentException("잘못된 기능 번호입니다.");
        }
    }

    public String readRegistrationStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.\n");
        return readStationName();
    }

    public String readStationName() {
        String input = scanner.nextLine();
        validateNameLength(input);
        return input;
    }

    private void validateNameLength(String input) {
        if (input.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 2글자 이상이어야 합니다.");
        }
    }

    public String readDeleteStationName() {
        System.out.println("## 삭제할 역 이름을 입력하세요.\n");
        return readStationName();
    }

    public String readLineNumber() {
        System.out.println("## 노선 관리 화면\n"
            + "1. 노선 등록\n"
            + "2. 노선 삭제\n"
            + "3. 노선 조회\n"
            + "B. 돌아가기");
        printFeatureMessage();
        String input = scanner.nextLine();
        validateStationAndLineNumber(input);
        return input;
    }

    public String readRegistrationLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.\n");
        return readLineName();
    }

    public String readLineName() {
        String input = scanner.nextLine();
        validateNameLength(input);
        return input;
    }

    public String readUpEndLineName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        return readLineName();
    }

    public String readDownEndLineName() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        return readLineName();
    }

    public String readDeleteLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.\n");
        return readLineName();
    }
}
