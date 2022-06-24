package kr.gmtc.resttest.model.info.group;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member implements Serializable {
    @SerializedName("groupId") protected Integer groupId;
    @SerializedName("memberType") protected Integer memberType;
    @SerializedName("memberId") protected String memberId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(groupId, member.groupId) && Objects.equals(memberType, member.memberType) && Objects.equals(memberId, member.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, memberType, memberId);
    }
}
