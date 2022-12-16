package subway.domain;

public class LineService {

    public void addLine(String name) {
        validateDuplicateLine(name);
        Line line = new Line(name);
        LineRepository.addLine(line);
    }

    private void validateDuplicateLine(String name) {
        if (LineRepository.findByName(name) != null) {
            throw new IllegalArgumentException("이미 존재하는 노선 이름입니다.");
        }
    }

}
