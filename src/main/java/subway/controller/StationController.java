package subway.controller;

import java.util.List;
import java.util.stream.Collectors;
import subway.Constants;
import subway.domain.Station;
import subway.domain.StationService;

public class StationController extends Controller {

    public void run() {
        String stationNumber = inputView.readStationNumber();
        if (stationNumber.equals(Constants.INPUT_REGISTRATION)) {
            register();
        }
        if (stationNumber.equals(Constants.INPUT_DELETE)) {
            delete();
        }
        if (stationNumber.equals(Constants.INPUT_SEARCH)) {
            search();
        }
    }

    private void register() {
        String stationName = repeat(inputView::readRegistrationStationName);
        StationService.addStation(stationName);
    }

    private void delete() {
        String stationName = repeat(inputView::readDeleteStationName);
        StationService.deleteStation(stationName);
    }

    private void search() {
        List<String> stationNames = StationService.findAll()
            .stream()
            .map(Station::getName)
            .collect(Collectors.toList());
        outputView.printStations(stationNames);
    }
}
