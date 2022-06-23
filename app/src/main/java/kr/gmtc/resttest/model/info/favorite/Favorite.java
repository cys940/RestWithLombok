package kr.gmtc.resttest.model.info.favorite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Favorite {
    protected Integer id;
    protected String userId;
    protected Integer destType;
    protected String destId;
}

