package lotto.model;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int START = 1;

    private static final int END = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber newInstance(int lottoNumber) {
        validRange(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    private static void validRange(int lottoNumber) {
        if (lottoNumber < START || END < lottoNumber) {
            throw new IllegalArgumentException(String.format("로또 숫자의 범위는 %d부터 %d까지입니다.", START, END));
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return this.lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
