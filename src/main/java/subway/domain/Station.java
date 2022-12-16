package subway.domain;

import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class Station {

    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상이어야 합니다.");
        }
    }

    public static boolean isDuplicated(String name) {
        return StationRepository.getStationCountByName(name) > 0;
    }

    public void add() {
        StationRepository.addStation(this);
    }

    public boolean isRegistered() {
        return LineRepository.getStationCountInLines(this) > 0;
    }

}
