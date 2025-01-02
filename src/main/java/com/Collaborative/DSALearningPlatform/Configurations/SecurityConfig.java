package com.Collaborative.DSALearningPlatform.Configurations;

// This is the package declaration for the configuration classes 
// used in the Collaborative DSA Learning Platform project.

//import org.springframework.context.annotation.Configuration; 
// The Configuration annotation marks this class as a source of bean definitions 
// for the application context.

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// This import is used for configuring HTTP security, such as authentication 
// and authorization policies.

//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// The EnableWebSecurity annotation enables Spring Security for the application.

//@Configuration
//@EnableWebSecurity
// The SecurityConfig class is a configuration class for Spring Security.
// It extends WebSecurityConfigurerAdapter, which provides methods to customize 
// security settings like authentication and authorization rules.

//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable() // Disable CSRF protection, which is not required 
//                             // if the application does not use sessions for security.
//                .authorizeRequests() // Begin configuration for request authorization.
//                .antMatchers("/**").permitAll()  // Allows all requests to pass 
//                                               // without authentication.
//                .anyRequest().permitAll();  // Permits any other requests as well.
//    }
//}

// This commented-out class is intended to provide a basic security configuration 
// where all endpoints are accessible without requiring authentication.
// Note: This configuration is suitable for development or non-sensitive environments 
// but should not be used in production as it does not enforce any security measures.
