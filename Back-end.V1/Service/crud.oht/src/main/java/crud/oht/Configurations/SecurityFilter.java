package crud.oht.Configurations;

import crud.oht.Configurations.TokenService.toekService;
import crud.oht.userPropeties.Repositorys.Repository_user;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private Repository_user user;

    @Autowired
    private toekService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var TokenJWT = RecuperarToken(request);

        if (TokenJWT != null) {
            var TokenJWvalidado = tokenService.verifyTO(TokenJWT);
            var usuario = user.findByCPF(TokenJWvalidado);

            var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }



    private String RecuperarToken (HttpServletRequest http){

        var TokenRecuperado = http.getHeader("Authorization");

        if (TokenRecuperado != null) {
            return TokenRecuperado.replace("Bearer","").trim();
        }
        return null;

    }
}
