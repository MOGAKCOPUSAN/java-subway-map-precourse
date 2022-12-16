package subway.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SubwayLineRepository {

    private static final HashMap<Line, List<Station>> store = new HashMap<>();

    public static HashMap<Line, List<Station>> subwayLines() {
        return (HashMap<Line, List<Station>>) Collections.unmodifiableMap(store);
    }

    public static void addSection(Line line, Station station, int order) {
        List<Station> values = store.getOrDefault(line, new ArrayList<>());
        values.add(order, station);
        store.put(line, values);
    }

    public static List<Station> findByLineName(Line line) {
        if (store.containsKey(line)) {
            return store.get(line);
        }
        return new ArrayList<>();
    }

    public static boolean isPresentStation(String stationName) {
        return store.values()
            .stream()
            .flatMap(Collection::stream)
            .anyMatch(i -> i.getName().equals(stationName));
    }

    public static boolean deleteStation(Line line, Station station) {
        if (store.containsKey(line)) {
            List<Station> stations = store.get(line);
            if (stations.contains(station)) {
                stations.remove(station);
                store.put(line, stations);
                return true;
            }
        }
        return false;
    }
}
