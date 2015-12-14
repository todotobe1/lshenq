package cn.lshenq.api.order;

import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@ImportResource("classpath:spring-security.xml")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user")
				.password("password").roles("USER");
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/orders/**").authenticated()
				.antMatchers(HttpMethod.GET, "/orders/**").authenticated().antMatchers(HttpMethod.DELETE, "/orders/**")
				.authenticated().anyRequest().permitAll().and().httpBasic().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
