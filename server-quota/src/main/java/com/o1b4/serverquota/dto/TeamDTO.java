package com.o1b4.serverquota.dto;

public class TeamDTO {
    private Long teamId;
    private String teamName;
    private String teamProfileImage;
    private String teamUrl;
    private String teamDescription;

    public TeamDTO() {

    }

    public TeamDTO(Long teamId, String teamName, String teamProfileImage, String teamUrl, String teamDescription) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamProfileImage = teamProfileImage;
        this.teamUrl = teamUrl;
        this.teamDescription = teamDescription;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamProfileImage() {
        return teamProfileImage;
    }

    public void setTeamProfileImage(String teamProfileImage) {
        this.teamProfileImage = teamProfileImage;
    }

    public String getTeamUrl() {
        return teamUrl;
    }

    public void setTeamUrl(String teamUrl) {
        this.teamUrl = teamUrl;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamProfileImage='" + teamProfileImage + '\'' +
                ", teamUrl='" + teamUrl + '\'' +
                ", teamDescription='" + teamDescription + '\'' +
                '}';
    }
}
