package hello.core.repository;

import hello.core.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByMemberEmail(String memberEmail);

}
