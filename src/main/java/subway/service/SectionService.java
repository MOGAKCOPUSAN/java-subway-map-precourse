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
}
