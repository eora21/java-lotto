package lotto.model;

import java.util.Map;
import java.util.Map.Entry;

public class Yield {

    public double calculate(Map<WinningRank, Integer> winningStatus, int purchaseAmount) {
        long totalPriceMoney = 0L;

        for (Entry<WinningRank, Integer> entry : winningStatus.entrySet()) {
            totalPriceMoney += (long)entry.getKey().getPrizeMoney() * entry.getValue();
        }

        return totalPriceMoney / (double)purchaseAmount;
    }
}
