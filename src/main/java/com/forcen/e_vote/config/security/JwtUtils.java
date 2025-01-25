package com.forcen.e_vote.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;


@Component
public class JwtUtils {

    @Value("${app.secret-key}")
    private String secretKey;

    // Temps d'expiration des tokens en millisecondes, injecté depuis les propriétés de l'application
    @Value("${app.expiration-time}")
    private long expirationTime;

    /**
     * Génère un JWT pour un utilisateur authentifié.
     *
     * @param authentication L'objet Authentication contenant les détails de l'utilisateur.
     * @return Un token JWT signé en tant que chaîne compacte.
     */
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();// Récupère le nom d'utilisateur

        return Jwts.builder()
                .subject(username)                              // Définit l'utilisateur comme sujet du token
                .issuedAt(new Date(System.currentTimeMillis())) // Date de génération du token
                .expiration(new Date(System.currentTimeMillis() + expirationTime)) // Définit la date d'expiration
                .signWith(key(), SignatureAlgorithm.HS512)     // Signe le token avec la clé secrète en utilisant l'algorithme HMAC-SHA256
                .compact();                                    // Génère le token JWT compact
    }

    /**
     * Décodage de la clé secrète pour l'utiliser dans les signatures.
     *
     * @return La clé cryptographique dérivée de la clé secrète encodée en Base64.
     */
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)); // Convertit la clé Base64 en clé utilisable
    }

    /**
     * Extrait le nom d'utilisateur contenu dans un token JWT.
     *
     * @param token Le token JWT.
     * @return Le nom d'utilisateur (subject) contenu dans le token.
     */
    public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);                          // Retourne le "subject" du token (nom d'utilisateur)
    }

    /**
     * Valide un token JWT.
     *
     * @param token Le token JWT à valider.
     * @return true si le token est valide et non expiré, sinon false.
     */
    public boolean validateToken(String token) {
        Jwts.parser()
                .verifyWith((SecretKey) key())                 // Définit la clé pour vérifier la signature
                .build()
                .parse(token);                                 // Analyse le token pour vérifier sa validité
        return !isTokenExpired(token);                        // Vérifie que le token n'a pas expiré
    }

    /**
     * Vérifie si un token JWT a expiré.
     *
     * @param token Le token JWT à vérifier.
     * @return true si le token est expiré, sinon false.
     */
    private Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration)      // Extrait la date d'expiration du token
                .before(new Date());                          // Compare avec la date actuelle
    }

    /**
     * Extrait une information spécifique (claim) du token JWT.
     *
     * @param token Le token JWT.
     * @param claimsResolver Fonction pour extraire une partie des claims.
     * @param <T> Le type de l'information extraite.
     * @return L'information extraite du token.
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);         // Récupère tous les claims du token
        return claimsResolver.apply(claims);                   // Applique la fonction pour extraire le claim spécifique
    }

    /**
     * Extrait tous les claims contenus dans un token JWT.
     *
     * @param token Le token JWT.
     * @return Un objet Claims contenant toutes les informations du payload.
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key())                 // Définit la clé pour la validation
                .build()
                .parseSignedClaims(token)                      // Analyse et décompose le token
                .getPayload();                                 // Retourne les claims (données)
    }
}
