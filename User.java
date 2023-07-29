import java.io.*;
import java.util.*;

public class User implements Serializable {
    private String username;
    private String password;
    private UserRole role;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters
}
enum UserRole {
    ADMIN,
    TEAM_LEADER,
    TEAM_MEMBER
}
