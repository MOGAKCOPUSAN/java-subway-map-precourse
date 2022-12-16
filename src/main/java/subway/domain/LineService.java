package subway.domain;

import java.util.List;

public class LineService {

    public static void addLine(String name) {
        validateDuplicateLine(name);
        Line line = new Line(name);
        LineRepository.addLine(line);
    }

    private static void validateDuplicateLine(String name) {
        if (LineRepository.findByName(name) != null) {
            throw new IllegalArgumentException("이미 존재하는 노선 이름입니다.");
        }
    }

    public static boolean deleteLine(String name) {
        return LineRepository.deleteLineByName(name);
    }

    public static Line findByName(String name) {
        return LineRepository.findByName(name);
    }

    public static List<Line> findAll() {
        return LineRepository.lines();
    }
}
