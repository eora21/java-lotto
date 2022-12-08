package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoShop;
import lotto.model.WinningLotto;
import lotto.model.WinningRank;
import lotto.model.Yield;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input = new Input();

    private final Output output = new Output();

    private final LottoShop lottoShop = new LottoShop();

    private final Yield yield = new Yield();

    public void run() {
        try {
            int purchaseAmount = purchaseAmount();
            List<Lotto> lottoBundle = lottoShop.buyLotto(purchaseAmount);
            lottoStatus(lottoBundle);
            WinningLotto winningLotto = new WinningLotto(winningNumber(), bonusNumber());
            Map<WinningRank, Integer> winningState = winningLotto.calculateWinningState(lottoBundle);
            result(winningState, yield.calculate(winningState, purchaseAmount));
        } catch (IllegalArgumentException e) {
            output.error(e.getMessage());
        }
    }

    private int purchaseAmount() {
        output.requirePurchaseAmount();
        int purchaseAmount = input.purchaseAmount();
        output.blank();

        return purchaseAmount;
    }

    private void lottoStatus(List<Lotto> lottoBundle) {
        output.lottoStatus(lottoBundle);
        output.blank();
    }

    private Lotto winningNumber() {
        output.requireWinningNumber();
        Lotto winningNumber = input.winningNumber();
        output.blank();

        return winningNumber;
    }

    private LottoNumber bonusNumber() {
        output.requireBonusNumber();
        LottoNumber bonusNumber = input.bonusNumber();
        output.blank();

        return bonusNumber;
    }

    private void result(Map<WinningRank, Integer> winningStatus, double yield) {
        output.winningStatistics(winningStatus);
        output.totalYield(yield);
    }

}
