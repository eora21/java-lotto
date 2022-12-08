package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.WinningRank;

public class Output {

    private final DecimalFormat moneyFormat = new DecimalFormat("###,###");
    private final DecimalFormat yieldFormat = new DecimalFormat("###,###.#");

    public void requirePurchaseAmount() {
        notice("구입금액을 입력해 주세요.");
    }

    public void lottoStatus(List<Lotto> lottoBundle) {
        notice(String.format("%d개를 구매했습니다.", lottoBundle.size()));

        for (Lotto lotto : lottoBundle) {
            noticeLottoNumbers(lotto);
        }
    }

    public void requireWinningNumber() {
        notice("당첨 번호를 입력해 주세요.");
    }

    public void requireBonusNumber() {
        notice("보너스 번호를 입력해 주세요.");
    }

    public void winningStatistics(Map<WinningRank, Integer> winningStatus) {
        notice("당첨 통계");
        notice("---");

        winningStatus.forEach(((winningRank, count) -> {
            notice(String.format("%s - %d개", createDescription(winningRank), count));
        }));
    }

    public void totalYield(double yield) {
        notice(String.format("총 수익률은 %s%%입니다.", yieldFormat.format(yield)));
    }

    public void error(String errorText) {
        notice(String.format("[ERROR]: %s", errorText));
    }

    private String createDescription(WinningRank winningRank) {
        String description = winningRank.getDescription();

        if (description.length() > 0) {
            description = ", " + description;
        }

        return String.format("%d개 일치%s (%s원)",
                winningRank.getCorrectCount(), description, moneyFormat.format(winningRank.getPrizeMoney()));
    }

    private void noticeLottoNumbers(Lotto lotto) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (LottoNumber number : lotto.getNumbers()) {
            stringJoiner.add(String.valueOf(number.getLottoNumber()));
        }

        notice(stringJoiner.toString());
    }

    private void notice(String text) {
        System.out.println(text);
    }

    public void blank() {
        System.out.println();
    }

}
