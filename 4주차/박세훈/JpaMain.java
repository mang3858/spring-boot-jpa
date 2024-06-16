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
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city1", "street", "zipcode"));

            member.getFavoriteFoods().add("A");
            member.getFavoriteFoods().add("B");
            member.getFavoriteFoods().add("C");

            member.getAddressHistory().add(new Address("1", "2", "3"));
            member.getAddressHistory().add(new Address("4", "5", "6"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=========");
            Member findMember = em.find(Member.class, member.getId());
//            Address address = new Address("city", "street", "zipcode");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);

//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//
//            member.getHomeAddress().setCity("newcity");

//            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
//            member.setHomeAddress(newAddress);

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
