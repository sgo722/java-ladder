package model.ladder;

public class Height {

    private final int height;

    public Height(String height){
        validate(height);
        this.height = Integer.parseInt(height);
    }

    public Height(int height) {
        this.height = height;
    }

    private void validate(String height){
        // 높이 검증
        validatePositiveNumber(height);
    }

    private void validatePositiveNumber(String height){
        validateNumber(height);
        try{
            validatePositive(Integer.parseInt(height));
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
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

    public int getHeight() {
        return height;
    }
}
