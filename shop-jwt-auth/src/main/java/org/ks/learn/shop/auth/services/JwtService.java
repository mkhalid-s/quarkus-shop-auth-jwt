package org.ks.learn.shop.auth.services;

import io.smallrye.jwt.build.Jwt;

import javax.inject.Singleton;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class JwtService {

    Set<String> adminWriterRoles = new HashSet<>(
            Arrays.asList("admin", "writer")
    );

    Set<String> writerRoles = new HashSet<>(
            Arrays.asList("writer")
    );

    Set<String> adminRoles = new HashSet<>(
            Arrays.asList("admin")
    );
    public String generateJwtToken(){
        return Jwt.issuer("shop-jwt-auth")
                .subject("shop-jwt-auth")
                .groups(adminWriterRoles)
                .expiresIn(Duration.ofDays(365))
                .sign();

    }
}
