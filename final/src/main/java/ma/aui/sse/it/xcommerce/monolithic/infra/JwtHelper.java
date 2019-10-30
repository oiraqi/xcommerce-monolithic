package ma.aui.sse.it.xcommerce.monolithic.infra;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtHelper {

    private static final String SIGNING_KEY = "Mq3vpOyK2wuhz_sMLwrSNnO8BJtnFzk9s0uooBmWwY1CZtKusIrhRA1ImhhaoakdcSEe4NS053-rXh-dYzmxOQ";

    private JwtHelper() {
    }

    public static String generateToken(Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        List<String> authorities = user.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

        long now = System.currentTimeMillis();
        long expirationTime = now + 1000 * 60 * 60 * 24;

        return Jwts.builder().setSubject(user.getUsername()).setHeaderParam("typ", "JWT").setIssuedAt(new Date(now))
                .setExpiration(new Date(expirationTime)).claim("roles", authorities)
                .signWith(Keys.hmacShaKeyFor(SIGNING_KEY.getBytes()),
                    SignatureAlgorithm.HS512)
                .compact();
    }

    public static Authentication parse(HttpServletRequest request) {        
        String auth = request.getHeader("Authorization");
        if (auth == null || !auth.startsWith("Bearer "))
            return null;
        
        Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY.getBytes())
                            .parseClaimsJws(auth.replace("Bearer ", "")).getBody();

        String username = claims.getSubject();
        List<SimpleGrantedAuthority> authorities = ((List<?>)(claims.get("roles"))).stream()
        .map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
        
        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

}