package flagcamp.authdeal;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Override
  // FYI: https://zhuanlan.zhihu.com/p/92077616
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .formLogin()
        .and()
        .authorizeRequests()
          .antMatchers(HttpMethod.GET, "/**").hasAnyAuthority("ROLE_ADMIN");

    http
        .authorizeRequests()
          .antMatchers("/users*/**").hasAuthority("ROLE_USER")
          .antMatchers("/order/**").hasAuthority("ROLE_ADMIN")
          .antMatchers("/item*/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
          .antMatchers("/messages/**").hasAuthority("ROLE_ADMIN")
          .anyRequest().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("admin")
        .authorities("ROLE_ADMIN").and().passwordEncoder(passwordEncoder());
  }

  @SuppressWarnings("deprecation")
  @Bean
  public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
  }
}
