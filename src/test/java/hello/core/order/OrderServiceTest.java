package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach //Test를 실행 전에 실행이 된다.
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrder() throws Exception {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
