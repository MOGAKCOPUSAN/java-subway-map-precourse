package subway.view;

import java.util.List;

public class OutputView {

    public static final String RESULT_PREFIX = "[INFO] ";

    public void printError(String errorMessage) {
        final String ERROR_LOG_PREFIX = "[ERROR] ";
        System.out.println(ERROR_LOG_PREFIX + errorMessage);
    }

    public void printRegisterStation() {
        System.out.println(RESULT_PREFIX + "지하철 역이 등록되었습니다.");
    }

    public void printDeleteStation() {
        System.out.println(RESULT_PREFIX + "지하철 역이 삭제되었습니다.");
    }

    public String printResult(List<String> stationNames) {
        StringBuilder sb = new StringBuilder();
        for (String stationName : stationNames) {
            sb.append(RESULT_PREFIX + stationName + "\n");
        }
        return sb.toString();
    }
}
