package subway.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubwayLineServiceTest {

    @Test
    @DisplayName("구간 등록시 해당 역이 종점이 되면 상태를 바꿔준다")
    void 구간_등록_역_상태_변경_테스트() {
        //given
        LineService.addLine("line1");
        Line line1 = LineService.findByName("line1");

        StationService.addStation("station1");
        Station station1 = StationService.findByName("station1");

        Assertions.assertThat(station1.isEndStation())
            .isFalse();
        //when
        SubwayLineService.addSection(line1, station1, 1);

        //then
        Assertions.assertThat(station1.isEndStation())
            .isTrue();
    }

    @Test
    @DisplayName("종점 삭제시 종점이 바뀐다.")
    void 종점_삭제시_종점_변경_테스트() {
        //given
        LineService.addLine("line");
        Line line = LineService.findByName("line");

        Station station1 = StationService.addStation("station1");
        Station station2 = StationService.addStation("station2");
        Station station3 = StationService.addStation("station3");

        SubwayLineService.addSection(line, station1, 1);
        SubwayLineService.addSection(line, station2, 2);
        SubwayLineService.addSection(line, station3, 3);

        Assertions.assertThat(station2.isEndStation()).isFalse();
        //when
        SubwayLineService.deleteSection(line, station3);
        //then
        Assertions.assertThat(station2.isEndStation()).isTrue();
    }
}
