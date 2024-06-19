package crud.oht.Configurations.TokenService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import crud.oht.userPropeties.JPAentity.Entity_user;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class toekService {

    public String TokenGeneration (Entity_user entityUser) {

            try {
                var algoritmo = Algorithm.HMAC256("12345678");
                return JWT.create()
                        .withIssuer("API-REST")
                        .withSubject(entityUser.getCPF())
                        .withExpiresAt(dataExpiracao())
                        .sign(algoritmo);
            } catch (JWTCreationException exception){
                throw new RuntimeException("erro ao gerrar token jwt", exception);}}

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

    public String verifyTO(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256("12345678");
            return JWT.require(algoritmo)
                    .withIssuer("API-REST")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }
}
