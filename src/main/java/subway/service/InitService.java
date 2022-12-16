package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitService {

    public void init() {
        initStation();
        initLine();
    }

    private void initStation() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<Station> stations = stationNames.stream()
                .map(Station::new)
                .collect(Collectors.toList());
        stations.forEach(Station::add);
    }

    private void initLine() {
        line2Init();
        line3Init();
        lineBundangInit();
    }

    private void lineBundangInit() {
        List<Station> lineBundangStations = Arrays.asList(StationRepository.findByName("강남역"),
                StationRepository.findByName("양재역"), StationRepository.findByName("양재시민의숲역"));
        Line lineBundang = new Line("신분당선", lineBundangStations);
        lineBundang.add();
    }

    private void line3Init() {
        List<Station> line3Stations = Arrays.asList(StationRepository.findByName("교대역"), StationRepository.findByName("남부터미널역"),
                StationRepository.findByName("양재역"), StationRepository.findByName("매봉역"));
        Line line3 = new Line("3호선", line3Stations);
        line3.add();
    }

    private void line2Init() {
        List<Station> line2Stations = Arrays.asList(StationRepository.findByName("교대역"),
                StationRepository.findByName("강남역"), StationRepository.findByName("역삼역"));
        Line line2 = new Line("2호선", line2Stations);
        line2.add();
    }
}
