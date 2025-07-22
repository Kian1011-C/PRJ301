package khainp.dtos;

public class UserDTO {
    private String userID;
    private String userName;
    private String email;
    private String roleID;

    public UserDTO(String userID, String userName, String email, String roleID) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.roleID = roleID;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getRoleID() {
        return roleID;
    }
}
