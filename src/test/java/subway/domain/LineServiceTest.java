package subway.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineServiceTest {
    @Test
    @DisplayName("노선을 등록시 이미 존재한다면 예외가 발생한다")
    void 노선_중복_확인_테스트() {
        LineService.addLine("새로운노선");

        Assertions.assertThatThrownBy(() -> LineService.addLine("새로운노선"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
