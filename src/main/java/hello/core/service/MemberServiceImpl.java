package hello.core.service;

import hello.core.dto.MemberDetailDTO;
import hello.core.dto.MemberLoginDTO;
import hello.core.dto.MemberSaveDTO;
import hello.core.entity.MemberEntity;
import hello.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository mr;

    // 회원정보 저장
    @Override
    public Long save(MemberSaveDTO memberSaveDTO) {

        MemberEntity memberEntity = MemberEntity.saveMember(memberSaveDTO);
        MemberEntity emailCheckResult = mr.findByMemberEmail(memberSaveDTO.getMemberEmail());

        if (emailCheckResult != null) {
            throw new IllegalStateException("중복된 이메일입니다");
        }

        return mr.save(memberEntity).getId();

    }

    // 회원 조회
    @Override
    public MemberDetailDTO findById(Long memberId) {


        MemberEntity member = mr.findById(memberId).get();

        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(member);
        System.out.println("memberDetailDTO.toString() = " + memberDetailDTO.toString());

        return memberDetailDTO;
    }

    // 회원 이메일 중복체크
    @Override
    public boolean login(MemberLoginDTO memberLoginDTO) {
        MemberEntity memberEntity = mr.findByMemberEmail(memberLoginDTO.getMemberEmail());
        if (memberEntity != null) {
            if (memberLoginDTO.getMemberPassword().equals(memberEntity.getMemberPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // 회원목록 요청
    @Override
    public List<MemberDetailDTO> findAll() {
        List<MemberEntity> memberEntityList = mr.findAll();
        List<MemberDetailDTO> memberList = MemberDetailDTO.change(memberEntityList);
        return memberList;
    }

}
