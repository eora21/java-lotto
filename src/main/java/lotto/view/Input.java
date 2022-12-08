package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int purchaseAmount() {
        String input = Console.readLine();
        return toInt(input);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환이 불가합니다.");
        }
    }
}
