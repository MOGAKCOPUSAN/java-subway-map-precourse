package subway.domain;

import java.util.List;

public class StationService {
    public static Station addStation(String name) {
        validateDuplicateLine(name);
        Station station = new Station(name);
        StationRepository.addStation(station);
        return station;
    }

    private static void validateDuplicateLine(String name) {
        if (StationRepository.findByName(name) != null) {
            throw new IllegalArgumentException("이미 존재하는 역 이름입니다.");
        }
    }

    public static Station findByName(String name) {
        return StationRepository.findByName(name);
    }

    public static boolean deleteStation(String name) {
        validateIsRegisteredSection(name);
        return StationRepository.deleteStation(name);
    }

    private static void validateIsRegisteredSection(String name) {
        // todo
        // 노선도에 등록되어 있다면 삭제할 수 없다.
//        if (SectionRepository.hasStation(name)) {
//            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
//        }
    }

    public static List<Station> findAll() {
        return StationRepository.stations();
    }
}
