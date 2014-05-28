package pw.bshkola.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("multipleRolesUserDetailsService")
public class MultipleRolesUserDetailsService implements UserDetailsService {

	private static final Map<String, String> usersMap = new HashMap<String, String>();
	private static final Map<String, String> usersRolesMap = new HashMap<String, String>();
	
	static {
		SaltPasswordEncoder encoder = new SaltPasswordEncoder();
		usersMap.put("user", encoder.encode("123"));
		usersMap.put("qwe", encoder.encode("qwe"));
	}
	
	static {
		usersRolesMap.put("user", "ROLE_USER");
		usersRolesMap.put("qwe", "ROLE_USER");
	}
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		String password = usersMap.get(username);
		if (password == null) {
			return null;
		}
		
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new GrantedAuthorityImpl(usersRolesMap.get(username)));
		
		return new MultipleRolesUser(0, username, password, roles);
	}
	
}
