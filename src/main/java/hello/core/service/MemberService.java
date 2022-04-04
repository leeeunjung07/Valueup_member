package hello.core.service;

import hello.core.dto.MemberDetailDTO;
import hello.core.dto.MemberLoginDTO;
import hello.core.dto.MemberSaveDTO;

import java.util.List;

public interface MemberService {

    Long save(MemberSaveDTO memberSaveDTO);

    MemberDetailDTO findById(Long memberId);

    boolean login(MemberLoginDTO memberLoginDTO);

    List<MemberDetailDTO> findAll();
}
