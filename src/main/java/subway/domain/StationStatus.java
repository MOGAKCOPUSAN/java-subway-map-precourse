package subway.domain;

public enum StationStatus {
    UP_END("상행종점"),
    DOWN_END("하행종점"),
    BASIC("기본");

    private final String name;

    StationStatus(String name) {
        this.name = name;
    }

    public boolean isEnd() {
        return name.endsWith("종점");
    }

    public boolean isUpEnd() {
        return name.equals("상행종점");
    }

    public boolean isDownEnd() {
        return name.equals("하행종점");
    }
}
