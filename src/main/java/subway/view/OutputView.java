package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class OutputView {

    private static String INPUT_SUCCESS_HEADER = "[INFO] ";
    private static String STATION_REGISTER_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static String STATION_DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static String LINE_REGISTER_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static String LINE_DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static String STATION_LIST_SHOW_MESSAGE = "## 역 목록";
    private static String LINE_LIST_SHOW_MESSAGE = "## 노선 목록";


    public void showStations(List<Station> stations) {
        printMessage(STATION_LIST_SHOW_MESSAGE);
        stations.forEach(station -> printMessage(INPUT_SUCCESS_HEADER + station.getName()));
    }

    public void showLines(List<Line> lines) {
        printMessage(LINE_LIST_SHOW_MESSAGE);
        lines.forEach(line -> printMessage(INPUT_SUCCESS_HEADER + line.getName()));
    }

    public void showStationRegisterResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + STATION_REGISTER_SUCCESS_MESSAGE);
    }

    public void showStationDeleteResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + STATION_DELETE_SUCCESS_MESSAGE);
    }

    public void showLineRegisterResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + LINE_REGISTER_SUCCESS_MESSAGE);
    }

    public void showLineDeleteResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + LINE_DELETE_SUCCESS_MESSAGE);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
