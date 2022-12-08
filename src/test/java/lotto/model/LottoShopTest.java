package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    LottoShop lottoShop = new LottoShop();

    @Test
    public void 로또_정상_발행() {
        Assertions.assertThatCode(() ->
                        lottoShop.buyLotto(5_000))
                .doesNotThrowAnyException();

    }

    @Test
    public void 로또_구입_불가() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        lottoShop.buyLotto(-1_000))
                .withMessageContaining("구매");

    }

    @Test
    public void 로또_나누어_떨어지지_않음() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        lottoShop.buyLotto(1_500))
                .withMessageContaining("나누어");

    }
}