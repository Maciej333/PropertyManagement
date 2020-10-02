package rogowski.maciej.property.management.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private AuthenticationSuccessHandler successHandler;
	
	private DataSource securityDataSource;
	
	@Autowired
	public SecurityConfig(AuthenticationSuccessHandler successHandler, @Qualifier("securityDataSource") DataSource securityDataSource) {
		this.successHandler = successHandler;
		this.securityDataSource = securityDataSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.jdbcAuthentication().dataSource(securityDataSource)
		.usersByUsernameQuery("SELECT username, user_password, enabled FROM user WHERE username=?")
		.authoritiesByUsernameQuery("SELECT username, user_role FROM role WHERE username=?");
	}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/user/user").hasRole("INHABITANT").
		antMatchers("/manager/manager").hasRole("MANAGER").
		antMatchers("/user/**").hasRole("INHABITANT").
		antMatchers("/manager/**").hasRole("MANAGER").
		antMatchers("/resources/**").permitAll()
		.and().formLogin().loginPage("/main/login")
		.loginProcessingUrl("/authenticate").successHandler(successHandler).permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/main/login?error");
	}

	
	
}
