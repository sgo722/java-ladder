package model.ladder;

public class Height {

    private final int height;

    public Height(String height){
        validate(height);
        this.height = Integer.parseInt(height);
    }

    public Height(int height){
        this.height = height;
    }

    private void validate(String height){
        validateNotBlank(height);
        validateNumber(height);
        validatePositive(Integer.parseInt(height));
    }

    private void validateNotBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이나 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNumber(String height){
        if (!height.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validatePositive(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
    }

    public Height install(){
        return new Height(this.height - 1);
    }

    public boolean canInstall () {
        return this.height > 0;
    }
}
