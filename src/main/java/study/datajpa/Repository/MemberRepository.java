package study.datajpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /*
    * 구현체는 spring-data-jpa가 만듬
    * MemberRepository 인터페이스가 동작한 이유
    * 실제 출력해보기(Proxy)
    * memberRepository.getClass() class com.sun.proxy.$ProxyXXX
    */

    /* 쿼리 메소드 제공 */
    List<Member> findByUsername(String username);

    /* 이름 기반 파라미터 바인딩 -> 위치 기반은 잘 사용하지 않음 */
    @Query("select m from Member m where m.username = :name")
    Member findMembers(@Param("name") String username);

    /* 컬렉션 파라미터 바인딩 -> in 절 사용 */
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);
}
