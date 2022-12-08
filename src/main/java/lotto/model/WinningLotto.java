package lotto.model;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class WinningLotto {

    private static final int DEFAULT_VALUE = 0;

    private final Set<LottoNumber> winningLotto;

    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validDuplicate(winningLotto.getNumbers(), bonusNumber);
        this.winningLotto = new HashSet<>(winningLotto.getNumbers());
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningRank, Integer> calculateWinningState(List<Lotto> lottoBundle) {
        Map<WinningRank, Integer> winningState = initWinningState();

        for (Lotto lotto : lottoBundle) {
            checkWinning(winningState, new HashSet<>(lotto.getNumbers()));
        }

        return winningState;
    }

    private void validDuplicate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    private Map<WinningRank, Integer> initWinningState() {
        return new EnumMap<>(WinningRank.class) {{
            for (WinningRank rank : WinningRank.values()) {
                put(rank, DEFAULT_VALUE);
            }
        }};
    }

    private void checkWinning(Map<WinningRank, Integer> winningState, Set<LottoNumber> lotto) {
        lotto.removeAll(winningLotto);
        int correctCount = Lotto.SIZE - lotto.size();
        boolean bonusState = lotto.contains(bonusNumber);
        calculateWinningState(winningState, correctCount, bonusState);
    }

    private static void calculateWinningState(Map<WinningRank, Integer> winningState, int correctCount,
            boolean bonusState) {
        Optional<WinningRank> optionalWinningRank = WinningRank.searchByCorrectCount(correctCount);

        if (optionalWinningRank.isPresent()) {
            WinningRank winningRank = getWinningRank(optionalWinningRank.get(), bonusState);
            winningState.put(winningRank, winningState.getOrDefault(winningRank, DEFAULT_VALUE) + 1);
        }
    }

    private static WinningRank getWinningRank(WinningRank winningRank, boolean bonusState) {
        if (winningRank == WinningRank.THIRD && bonusState) {
            winningRank = WinningRank.SECOND;
        }

        return winningRank;
    }
}
