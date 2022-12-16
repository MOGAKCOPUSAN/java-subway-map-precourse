package subway.domain;

public class Line {

    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 합니다.");
        }
    }
}
