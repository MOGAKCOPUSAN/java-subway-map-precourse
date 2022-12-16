package subway.domain;

import java.util.HashMap;
import java.util.List;

public class SubwayLineService {

    public static void addSection(Line line, Station station, int order) {
        int index = order - 1;
        validateCrossRoads(station);
        List<Station> stations = SubwayLineRepository.findByLineName(line);
        validateOrder(stations, index);
        changeStatus(stations, station, index);
        SubwayLineRepository.addSection(line, station, index);
    }

    private static void validateCrossRoads(Station station) {
        if (station.isEndStation()) {
            throw new IllegalArgumentException("노선에서 갈림길은 생길 수 없습니다.");
        }
    }

    private static void validateOrder(List<Station> stations, int index) {
        if (index < 0 || index > stations.size()) {
            throw new IllegalArgumentException("현재 노선에 맞는 순서를 입력하세요.");
        }
    }

    private static void changeStatus(List<Station> stations,Station station, int index) {
        if (stations.isEmpty()) {
            station.updateStatus(StationStatus.UP_END);
            return;
        }
        if (stations.size() == 1) {
            changeOneStations(stations, station, index);
            return;
        }
        if (index == 0) {
            changeUpEndStation(stations, station);
        }
        if (index == stations.size()) {
            changeDownEndStation(stations, station);
        }
    }

    private static void changeOneStations(List<Station> stations, Station station, int index) {
        if (index == 0) {
            stations.get(0).updateStatus(StationStatus.DOWN_END);
            station.updateStatus(StationStatus.UP_END);
            return;
        }
        stations.get(0).updateStatus(StationStatus.UP_END);
        station.updateStatus(StationStatus.DOWN_END);
    }

    private static void changeUpEndStation(List<Station> stations, Station station) {
        stations.get(0).updateStatus(StationStatus.BASIC);
        station.updateStatus(StationStatus.UP_END);
    }

    private static void changeDownEndStation(List<Station> stations, Station station) {
        stations.get(stations.size() - 1).updateStatus(StationStatus.BASIC);
        station.updateStatus(StationStatus.DOWN_END);
    }


    public static boolean deleteSection(Line line, Station station) {
        List<Station> stations = SubwayLineRepository.findByLineName(line);
        validateStationsSize(stations);
        if (station.isEndStation()) {
            changeEndStation(stations, station);
        }
        return SubwayLineRepository.deleteStation(line, station);
    }

    private static void changeEndStation(List<Station> stations, Station station) {
        if (station.isUpEndStation()) {
            stations.get(1).updateStatus(StationStatus.UP_END);
        }
        if (station.isDownEndStation()) {
            stations.get(stations.size() - 2).updateStatus(StationStatus.DOWN_END);
        }
    }

    private static void validateStationsSize(List<Station> stations) {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException("노선에 포함된 역이 두개 이하일 때는 삭제할 수 없습니다. ");
        }
    }

    public static HashMap<Line, List<Station>> findAll() {
        return SubwayLineRepository.subwayLines();
    }
}
