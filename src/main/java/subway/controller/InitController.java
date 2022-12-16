package subway.controller;

import subway.domain.Station;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitController {

    public void init() {
        initStation();
    }

    private void initStation() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<Station> stations = stationNames.stream()
                .map(Station::new)
                .collect(Collectors.toList());
        stations.forEach(Station::add);
    }
}
