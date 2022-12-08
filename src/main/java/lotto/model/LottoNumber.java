package lotto.model;

public class LottoNumber {

    private static final int START = 1;
    private static final int END = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validRange(int lottoNumber) {
        if (lottoNumber > START || END < lottoNumber) {
            throw new IllegalArgumentException(String.format("로또 숫자의 범위는 %d부터 %d까지입니다.", START, END));
        }
    }


}
