package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class Output {

    public void requirePurchaseAmount() {
        notice("구입금액을 입력해 주세요.");
    }

    public void lottoStatus(List<Lotto> lottoBundle) {
        notice(String.format("%d개를 구매했습니다.", lottoBundle.size()));

        for (Lotto lotto : lottoBundle) {
            noticeLottoNumbers(lotto);
        }
    }

    private void noticeLottoNumbers(Lotto lotto) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (LottoNumber number : lotto.getNumbers()) {
            stringJoiner.add(String.valueOf(number.getLottoNumber()));
        }

        notice(stringJoiner.toString());
    }

    public void requireWinningNumber() {
        notice("당첨 번호를 입력해 주세요.");
    }

    public void requireBonusNumber() {
        notice("보너스 번호를 입력해 주세요.");
    }

    private void notice(String text) {
        System.out.println(text);
    }

    public void blank() {
        System.out.println();
    }

}
