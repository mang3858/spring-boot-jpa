package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
//            em.detach(refMember);
//            em.clear();
//            em.close();

//            refMember.getUsername(); // 강제 초기화
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember)); // 초기화 여부 확인

//            Hibernate.initialize(refMember); // 강제 초기화
            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0); // 고아 객체 삭제

            tx.commit();

        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }


}
