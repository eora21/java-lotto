package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class Input {

    public int purchaseAmount() {
        String input = Console.readLine();
        return toInt(input);
    }

    public Lotto winningNumber() {
        String[] input = Console.readLine().split(",");

        return new Lotto(
                Arrays.stream(input)
                        .map(this::toInt)
                        .collect(Collectors.toList()));
    }

    public LottoNumber bonusNumber() {
        String input = Console.readLine();
        int number = toInt(input);
        return LottoNumber.newInstance(number);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환이 불가합니다.");
        }
    }
}
