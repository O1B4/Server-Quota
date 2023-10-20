package com.o1b4.serverquota.dto;

public class UserDTO {
    private Long userId;
    private String userEmail;
    private String userName;
    private String userProfileImage;

    public UserDTO() {

    }
    public UserDTO(Long userId, String userEmail, String userName, String userProfileImage) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userProfileImage='" + userProfileImage + '\'' +
                '}';
    }
}
