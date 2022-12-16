package subway.controller;

import subway.Constants;
import subway.domain.Line;
import subway.domain.LineService;
import subway.domain.Station;
import subway.domain.StationService;
import subway.domain.SubwayLineService;

public class SectionController extends Controller{

    @Override
    public void run() {
        String stationNumber = inputView.readSectionNumber();
        if (stationNumber.equals(Constants.INPUT_REGISTRATION)) {
            register();
        }
        if (stationNumber.equals(Constants.INPUT_DELETE)) {
            delete();
        }
    }

    private void register() {
        Line line = LineService.findByName(repeat(inputView::readSectionLine));
        Station station = StationService.findByName(repeat(inputView::readSectionStation));
        int order = Integer.parseInt(repeat(inputView::readSectionOrder));

        SubwayLineService.addSection(line, station, order);
        outputView.printRegisterSection();
    }

    private void delete() {
        Line line = LineService.findByName(repeat(inputView::readDeleteLineName));
        Station station = StationService.findByName(repeat(inputView::readDeleteStationName));
        SubwayLineService.deleteSection(line, station);
        outputView.printDeleteSection();
    }
}
