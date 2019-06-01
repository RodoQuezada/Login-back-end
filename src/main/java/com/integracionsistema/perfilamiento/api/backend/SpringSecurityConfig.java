package com.integracionsistema.perfilamiento.api.backend;

import com.integracionsistema.perfilamiento.api.backend.auth.filter.JwtAuthenticationFilter;
import com.integracionsistema.perfilamiento.api.backend.auth.filter.JwtAuthorizationFilter;
import com.integracionsistema.perfilamiento.api.backend.auth.service.JWTService;
import com.integracionsistema.perfilamiento.api.backend.models.services.JpaUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JpaUserDetailService userDetailService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder);

        /*  PasswordEncoder encoder = passwordEncoder();
        User.UserBuilder users = User.builder().passwordEncoder(encoder::encode);


        builder.userDetailsService(userDetailService)
                .passwordEncoder(encoder);
        */

        /*
        //creando un usuario en memoria
        builder.inMemoryAuthentication()
                .withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
                .withUser(users.username("rodo").password("12345").roles("USER"))
        ;*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/", "/css/**", "/js/**").permitAll()
              .anyRequest().authenticated()
          /*    .and()
              .formLogin().permitAll()
              .and()
              .logout().permitAll() */
              .and()
              .addFilter(new JwtAuthenticationFilter(authenticationManager(),jwtService))
              .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtService))
              .cors()
              .and()
              .csrf().disable()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



}
