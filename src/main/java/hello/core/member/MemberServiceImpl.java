package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 구현 클래스에 의존하지 말고, 인터페이스에 의존해야 좋은 객체 지향 설계가 된다. -> DIP
    // 하지만 순수 자바 언어를 사용한 이 코드에서는 인터페이스와 클래스 모두에게 의존하고 있다.
    // 변경이 있을 때 문제가 발생 (DIP 위반)
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
