package hello.core.dto;

import hello.core.entity.MemberEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberDetailDTO {

    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDetailDTO toMemberDetailDTO(MemberEntity member) {
        MemberDetailDTO memberDetailDTO = new MemberDetailDTO();
        memberDetailDTO.setMemberId(member.getId());
        memberDetailDTO.setMemberEmail(member.getMemberEmail());
        memberDetailDTO.setMemberPassword(member.getMemberPassword());
        memberDetailDTO.setMemberName(member.getMemberName());
        return memberDetailDTO;
    }

    public static List<MemberDetailDTO> change(List<MemberEntity> memberEntityList) {
        List<MemberDetailDTO> memberList = new ArrayList<>();
        for(MemberEntity m: memberEntityList) {
            memberList.add(toMemberDetailDTO(m));
        };
        return memberList;
    }

}
