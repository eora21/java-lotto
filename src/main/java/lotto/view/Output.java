package lotto.view;

public class Output {

    public void requirePurchaseAmount() {
        notice("구입금액을 입력해 주세요.");
    }

    private void notice(String text) {
        System.out.println(text);
    }

    public void blank() {
        System.out.println();
    }

}
