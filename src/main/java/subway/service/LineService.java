package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineService {

    public List<Line> getLines() {
        return LineRepository.lines();
    }

    public void add(String lineName, String upperStationName, String lowerStationName) {
        Station upperStation = StationRepository.findByName(upperStationName);
        Station lowerStation = StationRepository.findByName(lowerStationName);
        if (Line.isDuplicated(lineName)) {
            throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
        }
        Line line = new Line(lineName, new ArrayList<>(Arrays.asList(upperStation, lowerStation)));
        line.add();
    }

    public void delete(String lineName) {
        if (LineRepository.getLineCountByName(lineName) < 0) {
            throw new IllegalArgumentException("등록된 노선이 아닙니다.");
        }
        LineRepository.deleteLineByName(lineName);
    }
}
