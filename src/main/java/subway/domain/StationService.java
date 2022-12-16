package subway.domain;

public class StationService {
    public static void addStation(String name) {
        validateDuplicateLine(name);
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    private static void validateDuplicateLine(String name) {
        if (StationRepository.findByName(name) != null) {
            throw new IllegalArgumentException("이미 존재하는 역 이름입니다.");
        }
    }
}
