package study.datajpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /*
    * 구현체는 spring-data-jpa가 만듬
    * MemberRepository 인터페이스가 동작한 이유
    * 실제 출력해보기(Proxy)
    * memberRepository.getClass() class com.sun.proxy.$ProxyXXX
    */


}
