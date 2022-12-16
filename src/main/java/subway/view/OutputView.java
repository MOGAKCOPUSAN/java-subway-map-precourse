package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class OutputView {

    public static String INPUT_SUCCESS_HEADER = "[INFO] ";

    public static String STATION_REGISTER_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    public static String STATION_DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
    public static String LINE_REGISTER_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    public static String LINE_DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
    public static String SECTION_REGISTER_SUCCESS_MESSAGE = "구간이 등록되었습니다.";
    public static String SECTION_DELETE_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";

    public static String STATION_LIST_SHOW_MESSAGE = "## 역 목록";
    public static String LINE_LIST_SHOW_MESSAGE = "## 노선 목록";
    public static String SUBWAY_INFO_SHOW_MESSAGE = "## 지하철 노선도";
    public static String LINE_SEPARATOR = "---";
    public static String LINE_CHANGER = "";


    public void showStations(List<Station> stations) {
        printMessage(STATION_LIST_SHOW_MESSAGE);
        stations.forEach(station -> printMessage(INPUT_SUCCESS_HEADER + station.getName()));
    }

    public void showLines(List<Line> lines) {
        printMessage(LINE_LIST_SHOW_MESSAGE);
        lines.forEach(line -> printMessage(INPUT_SUCCESS_HEADER + line.getName()));
    }

    public void shoeLineAndStation(List<Line> lines) {
        printMessage(SUBWAY_INFO_SHOW_MESSAGE);
        lines.forEach(line -> {
            printMessage(INPUT_SUCCESS_HEADER + line.getName());
            printMessage(INPUT_SUCCESS_HEADER + LINE_SEPARATOR);
            line.getStations()
                    .forEach(station -> printMessage(INPUT_SUCCESS_HEADER + station.getName()));
            printMessage(LINE_CHANGER);
        });
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

    public void showSectionRegisterResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + SECTION_REGISTER_SUCCESS_MESSAGE);
    }

    public void showSectionDeleteResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + SECTION_DELETE_SUCCESS_MESSAGE);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
