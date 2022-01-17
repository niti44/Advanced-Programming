package com.example.demo.Car1.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

import static java.util.Collections.emptyList;

@Service
public class AuthenticationService {
    //defines the expiration time of the token in milliseconds
    static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
//    an algorithm-specific signing key that's used to digitally sign the JWT.use a
//    base64-encoded string to do this
    static final String SIGNINGKEY = "SecretKey";
    //defines the prefix of the token, and the Bearer schema is typically used
    //It just defines that a client can send a token, one given to them, that the server can accept to authorize the request. The Bearer scheme is just one of several ways to send the token
    static final String PREFIX = "Bearer";

    // Add token to Authorization header
    //The addToken method creates the token and adds it to the request's Authorization header
    static public void addToken(HttpServletResponse res, String username) {
        String JwtToken = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()
                        + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY) //The signing key is
        //encoded using the SHA-512 algorithm.
                .compact();

        //The method also adds Access-Control-Expose-Headers to the header with
        //the Authorization value. This is needed because we are unable to access the Authorization header through a
        //JavaScript frontend by default
        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");

    }

    //The getAuthentication method gets the token from the response Authorization
    //header using the parser() method provided by the jjwt library
    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null)
                //Spring Security hold the principal information of each authenticated user represented as an Authentication object.
                return new UsernamePasswordAuthenticationToken(user, null,
                        emptyList());
        }
        return null;
    }
}
