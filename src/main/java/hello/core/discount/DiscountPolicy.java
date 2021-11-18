package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 금액을 적용한 최종 금액
     */
    int discount(Member member, int price);

}
