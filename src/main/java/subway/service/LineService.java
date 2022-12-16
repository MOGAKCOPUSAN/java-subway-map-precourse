package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;

import java.util.List;

public class LineService {

    public List<Line> getLines() {
        return LineRepository.lines();
    }
}
