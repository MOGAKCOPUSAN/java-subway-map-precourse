package subway.service;

import subway.domain.Station;

public class StationService {

    public void add(String stationName) {
        if (Station.isDuplicated(stationName)) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }

        Station station = new Station(stationName);
        station.add();
    }
}
