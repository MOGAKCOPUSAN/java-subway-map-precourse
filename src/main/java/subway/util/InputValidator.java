package subway.util;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static String KOREAN_REGEX = "^[ㄱ-ㅎ가-힣]*$ ";
    private static String DIGIT_REGEX = "^[0-9]+$";

    public static void checkChoice(List<String> candidates, String choice) {
        if (!candidates.contains(choice)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
    }

    public static void checkKorean(String name) {
        if (!Pattern.matches(KOREAN_REGEX, name)) {
            throw new IllegalArgumentException("입력 값을 확인하세요.");
        }
    }

    public static void checkDigit(String digit) {
        if (!Pattern.matches(DIGIT_REGEX, digit)) {
            throw new IllegalArgumentException("노선은 숫자만 입력할 수 있습니다.");
        }
    }
}
