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

    // 추가 기능 구현
    public void validate(String name, List<Station> stations) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 합니다.");
        }

        if (stations.size() < 2) {
            throw new IllegalArgumentException("하나의 호선은 최소 2개의 역을 가져야 합니다.");
        }
    }

    public boolean isDuplicated(String name) {
        return LineRepository.isDuplicated(name) > 0;
    }

    public void add() {
        LineRepository.addLine(this);
    }
}
