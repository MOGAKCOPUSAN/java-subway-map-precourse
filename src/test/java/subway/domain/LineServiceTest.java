package subway.domain;


import java.util.Set;
import java.util.stream.Collectors;
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

    @Test
    @DisplayName("노선을 삭제하면 노선의 이름으로 찾았을 때 null을 반환한다")
    void 노선_삭제_테스트() {
        //given
        LineService.addLine("삭제할역");
        Assertions.assertThat(LineService.deleteLine("삭제할역"))
            .isNotNull();
        //when
        LineService.deleteLine("삭제할역");
        //then
        Assertions.assertThat(LineService.findByName("삭제할역"))
            .isNull();
    }

    @Test
    @DisplayName("노선 조회 테스트")
    void 노선_조회_테스트() {
        //given
        Set<String> lineNames = Set.of("노선1", "노선2", "노선3");
        //when
        for (String lineName : lineNames) {
            LineService.addLine(lineName);
        }
        //then
        Set<String> findLines = LineService.findAll().stream()
            .map(Line::getName)
            .collect(Collectors.toSet());
        Assertions.assertThat(findLines).containsAll(lineNames);
    }
}
