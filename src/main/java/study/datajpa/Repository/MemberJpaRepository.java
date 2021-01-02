package study.datajpa.Repository;

import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository // component scan + JPA의 예외를 스프링에서 공통적으로 처리할 수 있는 예외로 변환
public class MemberJpaRepository {
    @PersistenceContext
    private EntityManager em;

    public Member save(Member member) { em.persist(member);
        return member;
    }

    public void delete(Member member) { em.remove(member);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
            .getResultList();
    }

    public Optional<Member> findById(Long id) { Member member = em.find(Member.class, id); return Optional.ofNullable(member);
    }

    public long count() {
        return em.createQuery("select count(m) from Member m", Long.class)
            .getSingleResult();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
