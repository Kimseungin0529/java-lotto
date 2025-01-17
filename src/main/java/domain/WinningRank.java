package domain;

import java.util.Arrays;

public enum WinningRank {
    LAST_PLACE(0, false, 0),
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int matchingCount;
    private final boolean containsBonusNumber;
    private final int WinnerlottoPrice;

    WinningRank(int matchingCount, boolean containsBonusNumber, int winnerlottoPrice) {
        this.matchingCount = matchingCount;
        this.containsBonusNumber = containsBonusNumber;
        WinnerlottoPrice = winnerlottoPrice;
    }

    public static WinningRank findWinningRank(int matchingCount, boolean containsBonusNumber) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchingCount == matchingCount)
                .filter(winningRank -> winningRank.containsBonusNumber == containsBonusNumber)
                .findFirst()
                .orElse(WinningRank.LAST_PLACE);
    }

    public int getWinnerlottoPrice() {
        return WinnerlottoPrice;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

}
