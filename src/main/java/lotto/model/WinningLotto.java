package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final Set<LottoNumber> winningLotto;

    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validDuplicate(winningLotto.getNumbers(), bonusNumber);
        this.winningLotto = new HashSet<>(winningLotto.getNumbers());
        this.bonusNumber = bonusNumber;
    }

    private void validDuplicate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }
}
