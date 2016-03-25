package com.xxx.car.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CarSecurityFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return "ANONYMOUS";
			}
		});
		authorities.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return "MY";
			}
		});
		authorities.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return "YOU";
			}
		});
		Date date = new Date();
		User user = new User(123456, "15221559674", "zhaiyuyong","123","2323", date, date, false, false, true, false, authorities);
		//AnonymousAuthenticationToken token = new AnonymousAuthenticationToken("zyy", "zhaiyuyong", authorities);
		//SecurityContextHolder.getContext().setAuthentication(token);
		SecurityContextHolder.getContext().setAuthentication(createAuthentication(user));
        chain.doFilter(request, response);
	}
	
	 private Authentication createAuthentication(User user) {
	        UsernamePasswordAuthenticationToken authRequest;
	        authRequest = new UsernamePasswordAuthenticationToken(user.getUserId(),
	                user.getPassword(),
	                user.getAuthorities());
	        authRequest.setDetails(user);
	        return authRequest;
	    }

	@Override
	public void destroy() {
		
	}
	
	public static class User implements UserDetails{

		private static final long serialVersionUID = 7924306413481596924L;
		private final Integer userId;
	    private final String phoneNum;
	    private final String username;
	    private final String password;
	    private final String accessKey;
	    private final Date accountExpiredTime;
	    private final Date credentialsExpiredTime;
	    private final boolean isAccountNonExpired;
	    private final boolean isCredentialsNonExpired;
	    private final boolean isEnabled;
	    private final Boolean blocked;

	    private final List<GrantedAuthority> authorities;

	    public User(Integer userId, String phoneNum, String username, String password, String accessKey,
	                           Date accountExpiredTime, Date credentialsExpiredTime, boolean isAccountNonExpired,
	                           boolean isCredentialsNonExpired, boolean isEnabled,Boolean blocked,
	                           List<GrantedAuthority> authorities) {
	        this.userId = userId;
	        this.phoneNum = phoneNum;
	        this.username = username;
	        this.password = password;
	        this.accessKey = accessKey;
	        this.accountExpiredTime = accountExpiredTime;
	        this.credentialsExpiredTime = credentialsExpiredTime;
	        this.isAccountNonExpired = isAccountNonExpired;
	        this.isCredentialsNonExpired = isCredentialsNonExpired;
	        this.isEnabled = isEnabled;
	        this.blocked = blocked;
	        this.authorities = authorities;
	    }

	    public Integer getUserId() {
	        return userId;
	    }

	    public String getPhoneNum() {
	        return phoneNum;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getAccessKey() {
	        return accessKey;
	    }

	    public Date getAccountExpiredTime() {
	        return accountExpiredTime;
	    }

	    public Date getCredentialsExpiredTime() {
	        return credentialsExpiredTime;
	    }

	    public boolean isAccountNonExpired() {
	        return isAccountNonExpired;
	    }

	    public boolean isCredentialsNonExpired() {
	        return isCredentialsNonExpired;
	    }

	    public boolean isAccountNonLocked() {
	        return isAccountNonExpired && isCredentialsNonExpired;
	    }
	    
	    public boolean isEnabled() {
	        return isEnabled;
	    }

	    public List<GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    
	    
	    

	    @Override
	    public int hashCode() {
	        return userId.hashCode();
	    }

	    @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("BybeUserDetails{");
	        sb.append("userId=").append(userId);
	        sb.append(", phoneNum='").append(phoneNum).append('\'');
	        sb.append(", username='").append(username).append('\'');
	        sb.append(", password='").append(password).append('\'');
	        sb.append(", accessKey='").append(accessKey).append('\'');
	        sb.append(", accountExpiredTime=").append(accountExpiredTime);
	        sb.append(", credentialsExpiredTime=").append(credentialsExpiredTime);
	        sb.append(", isAccountNonExpired=").append(isAccountNonExpired);
	        sb.append(", isCredentialsNonExpired=").append(isCredentialsNonExpired);
	        sb.append(", isEnabled=").append(isEnabled);
	        sb.append(", blocked=").append(blocked);
	        sb.append(", authorities=").append(authorities);
	        sb.append('}');
	        return sb.toString();
	    }

		/**
		 * @return the blocked
		 */
		public Boolean getBlocked() {
			return blocked;
		}

		
	}

}
