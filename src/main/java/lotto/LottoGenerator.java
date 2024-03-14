package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int LOTTO_PER_PRICE = 1000;
    private final int ZERO = 0;
    private final String ONLY_PURCHASE_AMOUNT_IS_UNITS_OF_ONT_THOUSAND = "[ERROR] 구매 금액은 1000단위로만 받을 수 있습니다.";

    private final List<Lotto> lottos = new ArrayList<>();
    private final int lottoQuantity;

    public LottoGenerator(int money){ // 로또 생성하기
        moneyValidation(money);
        this.lottoQuantity = money / LOTTO_PER_PRICE;
    }

    private void moneyValidation(int money) {
        if(isZeroOrNegativeNumber(money) || isDividedByOneThousand(money)){
            throw new IllegalArgumentException(ONLY_PURCHASE_AMOUNT_IS_UNITS_OF_ONT_THOUSAND);
        }
    }

    private boolean isDividedByOneThousand(int money) {
        return money % LOTTO_PER_PRICE != 0;
    }

    private boolean isZeroOrNegativeNumber(int money) {
        return money <= ZERO;
    }

    // 사용자가 입력한 금액에 맞는 로또 개수를 생성합니다.


    // 각 로또 번호는 1부터 45까지의 숫자 중에서 중복되지 않는 번호로 구성됩니다.
    // 생성된 로또 번호는 오름차순으로 정렬됩니다.
}