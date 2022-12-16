package subway.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StationServiceTest {

    @Test
    @DisplayName("역을 등록시 이미 존재한다면 예외가 발생한다")
    void 역_중복_확인_테스트() {
        StationService.addStation("새로운역");

        Assertions.assertThatThrownBy(() -> StationService.addStation("새로운역"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("역을 삭제하면 역의 이름으로 찾았을 때 null을 반환한다")
    void 역_삭제_테스트() {
        //given
        StationService.addStation("삭제할역");
        Assertions.assertThat(StationService.findByName("삭제할역"))
            .isNotNull();
        //when
        StationService.deleteStation("삭제할역");
        //then
        Assertions.assertThat(StationService.findByName("삭제할역"))
            .isNull();
    }

    @Test
    @DisplayName("역 조회 테스트")
    void 역_조회_테스트() {
        //given
        Set<String> stationNames = Set.of("역1", "역2", "역3");
        //when
        for (String stationName : stationNames) {
            StationService.addStation(stationName);
        }
        //then
        Set<String> findStations = StationService.findAll().stream()
            .map(Station::getName)
            .collect(Collectors.toSet());
        Assertions.assertThat(findStations).containsAll(stationNames);
    }
}
