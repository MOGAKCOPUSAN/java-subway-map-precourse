package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {

    public void add(String lineName, String stationName, int index) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        line.insert(station, index - 1);
    }

    public void delete(String lineName, String stationName) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        if (line.hasNotStation(station)) {
            throw new IllegalArgumentException("해당 노선이 해당 역을 가지고 있지 않습니다.");
        }
        line.delete(station);
    }
}
