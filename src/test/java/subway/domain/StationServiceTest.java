package subway.domain;

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
}
