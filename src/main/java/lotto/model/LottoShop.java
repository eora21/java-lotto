package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final int UNIT_PRICE = 1_000;

    public List<Lotto> buyLotto(int purchaseAmount) {
        validPurchaseAmount(purchaseAmount);
        return issueLotto(howManyLotto(purchaseAmount));
    }

    private void validPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < UNIT_PRICE) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }
    }

    private int howManyLotto(int purchaseAmount) {
        if (purchaseAmount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(
                    String.format("%d으로 나누어떨어지지 않는 금액을 입력하셨습니다.", UNIT_PRICE));
        }

        return purchaseAmount / UNIT_PRICE;
    }

    private List<Lotto> issueLotto(int howManyLotto) {
        return new ArrayList<>(howManyLotto) {{
            while (this.size() < howManyLotto) {
                add(new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.START, LottoNumber.END, Lotto.SIZE)));
            }
        }};
    }

}
