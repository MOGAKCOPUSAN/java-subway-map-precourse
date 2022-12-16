package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;

import java.util.List;

public class StationService {

    public void add(String stationName) {
        if (Station.isDuplicated(stationName)) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }

        Station station = new Station(stationName);
        station.add();
    }

    public List<Station> getStations() {
        return StationRepository.stations();
    }

    public void delete(String name) {
        Station station = StationRepository.findByName(name);
        if (station.isRegistered()) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
        StationRepository.deleteStation(name);
    }
}
