package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.WinningRank;
import lotto.view.Input;
import lotto.view.Output;

public class ViewController {

    private final Input input = new Input();

    private final Output output = new Output();

    public int purchaseAmount() {
        output.requirePurchaseAmount();
        int purchaseAmount = input.purchaseAmount();
        output.blank();

        return purchaseAmount;
    }

    public void lottoStatus(List<Lotto> lottoBundle) {
        output.lottoStatus(lottoBundle);
        output.blank();
    }

    public Lotto winningNumber() {
        output.requireWinningNumber();
        Lotto winningNumber = input.winningNumber();
        output.blank();

        return winningNumber;
    }

    public LottoNumber bonusNumber() {
        output.requireBonusNumber();
        LottoNumber bonusNumber = input.bonusNumber();
        output.blank();

        return bonusNumber;
    }

    public void result(Map<WinningRank, Integer> winningStatus, double yield) {
        output.winningStatistics(winningStatus);
        output.totalYield(yield);
    }

}
