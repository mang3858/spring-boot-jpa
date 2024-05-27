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
//            em.persist(member); //JPA에 저장하기

            //멤버 찾기
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //멤버 삭제
//            em.remove(findMember);

            //멤버 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            // JPQL ; 데이터 조회 방법 ; 객체 지향 코드
            List<Member> result = em.createQuery("select m from Member as m", Member.class).setFirstResult(0).setMaxResults(2).getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}