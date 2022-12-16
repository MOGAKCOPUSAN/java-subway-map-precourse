package subway.domain;

import subway.repository.LineRepository;

import java.util.List;

public class Line {

    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> stations) {
        validate(name, stations);
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
    public void validate(String name, List<Station> stations) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 합니다.");
        }

        if (stations.size() < 2) {
            throw new IllegalArgumentException("하나의 호선은 최소 2개의 역을 가져야 합니다.");
        }
    }

    public static boolean isDuplicated(String name) {
        return LineRepository.getLineCountByName(name) > 0;
    }

    public void add() {
        LineRepository.addLine(this);
    }

    public void insert(Station station, int index) {
        validateIndex(index);
        if (index == stations.size()) {
            stations.add(station);
            return;
        }
        stations.add(index, station);
    }

    private void validateIndex(int index) {
        if (index < 0 || index > stations.size()) {
            throw new IllegalArgumentException("인덱스 범위를 확인하세요");
        }
    }

    public boolean hasNotStation(Station station) {
        return !stations.contains(station);
    }

    public void delete(Station station) {
        stations.remove(station);
    }
}
