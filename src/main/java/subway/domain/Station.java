package subway.domain;

public class Station {
    private String name;
    private StationStatus stationStatus = StationStatus.BASIC;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void updateStatus(StationStatus stationStatus) {
        this.stationStatus = stationStatus;
    }

    public boolean isEndStation() {
        return stationStatus.isEnd();
    }
}
