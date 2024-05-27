package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 멤버 등록하기
//            Member member = new Member();
//            member.setId(1l);
//            member.setName("HelloA"); //프로젝트 실행 단축키 : Shift + F10
//            -- 비영속 상태 --
//            em.persist(member); //JPA에 저장하기
//            -- 영속 상태 --
//            em.detach(member);
//            -- 준영속 상태 -- ; 회원 엔티티를 영속성 컨텍스트에서 분리

            //멤버 찾기
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //멤버 삭제
//            em.remove(findMember);

            //멤버 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            // JPQL ; 데이터 조회 방법 ; 객체 지향 코드 ; 엔티티 객체를 대상으로 쿼리를 날림 ; JPQL 실행 시 자동으로 flush 호출됨
/*            List<Member> result = em.createQuery("select m from Member as m", Member.class).setFirstResult(0).setMaxResults(2).getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }*/

            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

//            em.flush(); //쓰기 지연 SQL 저장소에 있는 쿼리가 DB에 반영됨


            tx.commit(); //플러시 : 영속성 컨텍스트의 변경내용을 데이터베이스에 반영
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
