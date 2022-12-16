package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 노선이 존재하지 않습니다."));
    }

    public static long getLineCountByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .count();
    }

    public static long getStationCountInLines(Station station) {
        return lines.stream()
                .filter(line -> line.getStations().contains(station))
                .count();
    }
}
