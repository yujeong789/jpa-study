package jpabook.start;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        // 엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        // 엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 기능 획득
        EntityTransaction tx = em.getTransaction();

        try {


            tx.begin(); // 트랜잭션 시작
            logic(em);  // 비즈니스 로직 실행
            tx.commit();// 트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 트랜잭션 롤백
        } finally {
            em.close(); // 엔티티 매니저 종료
        }

        emf.close(); // 엔티티 매니저 팩토리 종료
    }
    
    // 비즈니스 로직
    public static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("예영");
        member.setAge(28);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(29);
        
        // 특정 멤버 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("찾은 회원" + "\n" + "이름 : " + findMember.getUsername() + ", 나이 : " + findMember.getAge());

        // 목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("총 회원 수 : " + members.size());

        // 삭제
        em.remove(member);

    }
}
