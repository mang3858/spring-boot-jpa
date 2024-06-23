package jpal;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //EntityManagerFactory를 만드는 순간 데이터베이스랑 연결도 되고 웬만한건 다 됨
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //; 데이터베이스 커넥션 받았다고 생각
        //EntityManagerfmf 자바컬렉션처럼 생각; 객체를 나 대신 저장해주는 놈
        EntityManager em = emf.createEntityManager();

        ////데이터를 변경하는 모든 작업은 jpa에서 트랜잭션 안에서 작업을 해야 함
        EntityTransaction tx = em.getTransaction();
        //데이터베이스 트랜잭션 시작
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);


            Team team = new Team();
            team.setName("teamA");
            em.persist(member);

            em.flush();
            em.clear();

            //페이징 API
            //List<Member> resultList = em.createQuery("select m from Member m m order by m.age desc", Member.class)
            //        .setFirstResult(10)
            //        .setMaxResults(20)
            //        .getResultList();


            //Object[] 타입으로 조회
            //List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m")
            //       .getResultList();
            //Object[] result = resultList.get(0);
            //System.out.println("result = " + result[0]);
            //System.out.println("result = " + result[1]);

            /**
            // 단순 값을 DTO로 바로 가져올 수도 있음
            //new 명령어로 조회
            List<MemberDTO> resultList = em
                    // 패키지명.생성자로 불러옴
                    .createQuery("select new jpql.MemberDto(m.username, m.age) from Member m",
                            MemberDTO.class).getResultList();

            MemberDTO memberDto = resultList.get(0);

            System.out.println("result = " + memberDto.getUsername());
            System.out.println("result = " + memberDto.getAge());
             **/



            // 임베디드 타입 조회
            //em.createQuery("select o.address from Order o", Address.class).getResultList();

            // Entity 프로젝션으로 조회한 데이터는 영속성 컨텍스트에서 관리
            //List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();

            //Member findMember = result.get(0);
            // 영속성 컨텍스트에서 관리되기 때문에 update 쿼리가 나감
            //findMember.setAge(30);

            //List<Team> result = em.createQuery("select m.team from Member m", Team.class).getResultList();


            /**
            //TypedQuery라고 해서 Generic을 가지고 있음
            //왜냐? 타입 정보를 명확하게 명기했기 때문
            //TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            //컬렉션 반환

            //값이 하나만 있는 경우
            TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.id = 10", Member.class);
            Member result = query1.getSingleResult();

            List<Member> resultList = query1.getResultList();
            //
            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
            //타입 정보를 받을 수 없을 때는 Query 씀
            Query query3 = em.createQuery("select m.username, m.age from Member m", String.class);
            **/



            //이때 DB에 쿼리가 날아감
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            //문제가 생기면 롤백
            tx.rollback();
        } finally {
            //EntityManager가 내부적으로 데이터베이스 커넥션을 물고 동작하기 때문에 실제 애플리케이션이 끝나면 EntityManagerFactory 닫아줘야 함
            em.close();
        }
        emf.close();
    }

}
