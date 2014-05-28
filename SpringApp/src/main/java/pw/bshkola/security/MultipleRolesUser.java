package pw.bshkola.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MultipleRolesUser implements UserDetails {

	private static final long serialVersionUID = 4260618789432920553L;
	
	private Integer userId;
	private String username;
	private String password;
	private ArrayList<GrantedAuthority> authorities;
	
	public MultipleRolesUser(Integer userId, String username, String password, Collection<GrantedAuthority> authorities) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.authorities = (ArrayList<GrantedAuthority>) authorities;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public Integer getUserId() {
		return userId;
	}

}
