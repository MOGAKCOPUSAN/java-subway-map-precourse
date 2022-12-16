package subway.controller;

import subway.service.SectionService;
import subway.util.Log;
import subway.view.OutputView;
import subway.view.SectionInputView;

import java.io.IOException;

public class SectionController {

    public static final String SECTION_REGISTER = "1";
    public static final String SECTION_DELETE = "2";
    public static final String BACK = "B";

    private final SectionInputView sectionInputView = new SectionInputView();
    private final SectionService sectionService = new SectionService();
    private final OutputView outputView = new OutputView();

    public void run() {
        String userChoice = getUserChoice();
        start(userChoice);
    }

    private void start(String userChoice) {
        if (userChoice.equals(SECTION_REGISTER)) {
            register();
        }
        if (userChoice.equals(SECTION_DELETE)) {
            delete();
        }
        if (userChoice.equals(BACK)) {
            return;
        }
    }

    private void delete() {
        String lineName = getDeleteLine();
        String stationName = getDeleteStationName();
        try {
            sectionService.delete(lineName, stationName);
            outputView.showSectionDeleteResultMessage();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
        }
    }


    private void register() {
        String lineName = getRegisterLine();
        String stationName = getRegisterStationName();
        int sectionIndex = getSectionIndex();
        try {
            sectionService.add(lineName, stationName, sectionIndex);
            outputView.showSectionRegisterResultMessage();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
        }
    }

    private String getUserChoice() {
        try {
            return sectionInputView.getSectionManageChoice();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getUserChoice();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getUserChoice();
        }
    }

    private String getRegisterLine() {
        try {
            return sectionInputView.getRegisterSectionLine();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getRegisterLine();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getRegisterLine();
        }
    }

    private int getSectionIndex() {
        try {
            return sectionInputView.getSectionIndex();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getSectionIndex();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getSectionIndex();
        }
    }

    private String getRegisterStationName() {
        try {
            return sectionInputView.getRegisterSectionStation();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getRegisterStationName();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getRegisterStationName();
        }
    }

    private String getDeleteLine() {
        try {
            return sectionInputView.getDeleteSectionLine();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getDeleteLine();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getDeleteLine();
        }
    }

    private String getDeleteStationName() {
        try {
            return sectionInputView.getDeleteSectionStation();
        } catch (IOException e) {
            Log.error(e.getMessage());
            return getDeleteStationName();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getDeleteStationName();
        }
    }
}
