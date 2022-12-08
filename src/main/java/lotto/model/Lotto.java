package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = createLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validSize(numbers);
        validDuplicate(numbers);
    }

    private static void validSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(String.format("입력된 숫자들이 %d개로 이루어져있지 않습니다.", SIZE));
        }
    }

    private void validDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::newInstance)
                .collect(Collectors.toList());
    }
}
