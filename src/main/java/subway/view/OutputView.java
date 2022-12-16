package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {

    private static String INPUT_SUCCESS_HEADER = "[INFO] ";
    private static String STATION_INPUT_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static String STATION_DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static String STATION_LIST_SHOW_MESSAGE = "## 역 목록";


    public void showStations(List<Station> stations) {
        printMessage(STATION_LIST_SHOW_MESSAGE);
        stations.forEach(station -> printMessage(INPUT_SUCCESS_HEADER + station.getName()));
    }

    public void showRegisterResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + STATION_INPUT_SUCCESS_MESSAGE);
    }

    public void showDeleteResultMessage() {
        printMessage(INPUT_SUCCESS_HEADER + STATION_DELETE_SUCCESS_MESSAGE);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
