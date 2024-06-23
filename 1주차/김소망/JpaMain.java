package hellojpa;

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
            //EntityManager em을 꺼내고 이 안에서 실제 동작하는 코드 작성
            //code; DB에 데이터를 저장한다던가 불러온다던가
            //Member findmember = em.find(Member.class, 1L);
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            //정상적일 때는 커밋을 해주고
            tx.commit();
        } catch (Exception e){
            //문제가 생기면 롤백
            tx.rollback();
        } finally {
            //EntityManager가 내부적으로 데이터베이스 커넥션을 물고 동작하기 때문에 실제 애플리케이션이 끝나면 EntityManagerFactory 닫아줘야 함
            em.close();
        }
        emf.close();
    }
}
