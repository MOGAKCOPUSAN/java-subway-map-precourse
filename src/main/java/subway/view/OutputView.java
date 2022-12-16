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

    public void printStations(List<String> stationNames) {
        System.out.println("## 역 목록");
        printResult(stationNames);
    }

    public void printResult(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (String stationName : names) {
            sb.append(RESULT_PREFIX + stationName + "\n");
        }
        System.out.println(sb);
    }

    public void printRegisterLine() {
        System.out.println(RESULT_PREFIX + "지하철 노선이 등록되었습니다.");
    }

    public void printDeleteLine() {
        System.out.println(RESULT_PREFIX + "지하철 노선이 삭제되었습니다.");
    }

    public void printLines(List<String> lineNames) {
        System.out.println("## 노선 목록");
        printResult(lineNames);
    }
}
