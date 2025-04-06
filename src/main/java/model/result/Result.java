package model.result;

public class Result {

    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        validateNotBlank(result);
    }

    private void validateNotBlank(String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이나 공백을 입력할 수 없습니다.");
        }
    }
}
