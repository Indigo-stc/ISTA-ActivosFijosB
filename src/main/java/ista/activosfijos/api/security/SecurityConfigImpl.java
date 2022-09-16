package ista.activosfijos.api.security;

import ista.activosfijos.api.models.services.IUsuarioService;
import ista.activosfijos.api.models.services.IUsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigImpl extends WebSecurityConfigurerAdapter {

	@Autowired
	IUsuarioServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/api/auth/**").permitAll()
				.antMatchers("/api/test/**").permitAll()
				.anyRequest().authenticated();
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	/*protected void configure(HttpSecurity http) throws Exception {
		// Se agrego un nuevo constructor a la vista..
		FiltrosAuthentication filtrosAuthentication = new FiltrosAuthentication(authenticationManagerBean());
		filtrosAuthentication.setFilterProcessesUrl("/api/login");
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(STATELESS);
		http.authorizeRequests().antMatchers("/api/login/**").permitAll();
		http.authorizeRequests().antMatchers("/api/loginp").permitAll();
		http.authorizeRequests().antMatchers("/api/users/save").permitAll();
		http.authorizeRequests().antMatchers("/api/users/all").permitAll();
		http.authorizeRequests().antMatchers("/api/users/all").permitAll();
		http.authorizeRequests().antMatchers("/api/users").permitAll();
		http.authorizeRequests().antMatchers("/api/persona").permitAll();
		http.authorizeRequests().antMatchers("/api/personafenix/{cedula}").permitAll(); // http.authorizeRequests().antMatchers(GET,"/api/users/**").hasAnyAuthority("USER");
																						// //En este apartado le																			// http.authorizeRequests().anyRequest().permitAll();
		http.authorizeRequests().anyRequest().authenticated();

		// De igual forma solo le agregamos el objeto creado por el constructor.
		// http.addFilter(new FiltrosAuthentication(authenticationManagerBean()));
		http.addFilter(filtrosAuthentication);
	}*/


}
