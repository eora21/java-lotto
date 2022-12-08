package lotto.model;

import java.text.NumberFormat;

public enum WinningRank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, "보너스 볼 일치"),
    FIRST(6, 2_000_000_000);

    private final int correctCount;

    private final int prizeMoney;

    private final String description;

    WinningRank(int correctCount, int prizeMoney) {
        this(correctCount, prizeMoney, "");
    }

    WinningRank(int correctCount, int prizeMoney, String description) {
        this.correctCount = correctCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
