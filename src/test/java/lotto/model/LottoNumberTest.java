package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9, 13, 28, 37, 45})
    public void 로또_번호_생성(int lottoNumber) {
        Assertions.assertThatCode(() -> LottoNumber.newInstance(lottoNumber)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-45, -37, -28, -13, -9, -5, 0, 46, 57, 88, 96})
    public void 로또_번호_범위_벗어남(int lottoNumber) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.newInstance(lottoNumber))
                .withMessageContaining("범위");
    }

}