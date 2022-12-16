package subway.controller;

import java.util.List;
import java.util.stream.Collectors;
import subway.Constants;
import subway.domain.Line;
import subway.domain.LineService;

public class LineController extends Controller{

    public void run() {
        String stationNumber = inputView.readLineNumber();
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
        String lineName = repeat(inputView::readRegistrationLineName);
        LineService.addLine(lineName);
        outputView.printRegisterLine();
    }

    private void delete() {
        String lineName = repeat(inputView::readDeleteLineName);
        LineService.deleteLine(lineName);
        outputView.printDeleteLine();
    }

    private void search() {
        List<String> lineNames = LineService.findAll()
            .stream()
            .map(Line::getName)
            .collect(Collectors.toList());
        outputView.printStations(lineNames);
    }
}
