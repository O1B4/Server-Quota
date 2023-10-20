package com.o1b4.serverquota.dto;

public class BelongTeamDTO {
    private Long userId;
    private Long teamId;
    private String userRole;

    public BelongTeamDTO() {

    }

    public BelongTeamDTO(Long userId, Long teamId, String userRole) {
        this.userId = userId;
        this.teamId = teamId;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "BelongTeamDTO{" +
                "userId=" + userId +
                ", teamId=" + teamId +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
