package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

// 복합키를 사용하기 때문에 추가
@Getter
@Setter
public class BelongTeamId implements Serializable {
    private Long userId;
    private Long teamId;
}
