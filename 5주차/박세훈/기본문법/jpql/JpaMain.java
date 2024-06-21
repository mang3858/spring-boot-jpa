package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member");
            member.setAge(1);
            em.persist(member);

            member.setTeam(team);

            em.flush();
            em.clear();

            //language=HQL
            String query = "select group_concat(m.username) from Member m";
//                    "select coalesce(m.username, '이름없는 회원') from Member m";
//                   "select " +
//                           "case when m.age <= 10 then '학생요금'" +
//                           "     when m.age >= 60 then '경로요금'" +
//                           "     else '일반요금' end " +
//                   "from Member m";
            List<String> result = em.createQuery(query, String.class)
                    .getResultList();
            for (String s : result) {
                System.out.println("s = " + s);
            }


//            List<Member> result = em.createQuery(query, Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();




//            em.createQuery("select o.address from Order o", Address.class) // 임베디드 타입 프로젝션
//                            .getResultList();

//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO = " + memberDTO.getUsername());
//            System.out.println("memberDTO = " + memberDTO.getAge());
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
