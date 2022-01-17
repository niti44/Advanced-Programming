package com.example.demo;

import com.example.demo.Car1.Entity.AccountCredentials;
import com.example.demo.Car1.Service.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

//handles POST requests to the /login endpoint
public class LoginFilter extends AbstractAuthenticationProcessingFilter {
    public LoginFilter(String url, AuthenticationManager authManager) {
        //Matcher which compares a pre-defined ant-style pattern against the URL (servletPath + pathInfo) of an HttpServletRequest. The query string of the URL is ignored and matching is case-insensitive or case-sensitive depending on the arguments passed into the constructor.
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }
    //Authentication is performed by the attemptAuthentication method. If authentication is successful, the
    //succesfulAuthentication method is executed. This method will then call the addToken method in our service class,
    //and the token will be added to the Authorization header
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
        AccountCredentials creds = new ObjectMapper()
                                    .readValue(req.getInputStream(),
                                            AccountCredentials.class);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        creds.getPassword(),
                        Collections.emptyList()
                )
        );
    }
    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        AuthenticationService.addToken(res, auth.getName());
    }
}
