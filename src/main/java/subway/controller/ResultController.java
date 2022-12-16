package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.SubwayLineService;

public class ResultController extends Controller{

    @Override
    public void run() {
        HashMap<Line, List<Station>> subwayLines = SubwayLineService.findAll();
        Map<String, List<String>> result = new HashMap<>();
        subwayLines.keySet().stream()
            .forEach(k -> {
                List<String> stationNames = subwayLines.get(k).stream()
                    .map(Station::getName)
                    .collect(Collectors.toList());
                result.put(k.getName(), stationNames);
            });
        outputView.printSubwayLines(result);
    }
}
