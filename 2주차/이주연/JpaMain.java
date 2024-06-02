package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        // 트랜잭션 받아오기
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try{
            Member member = em.find(Member.class, 150L);
            member.setName("aaaaa");

            em.clear();

            System.out.println("==============");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
