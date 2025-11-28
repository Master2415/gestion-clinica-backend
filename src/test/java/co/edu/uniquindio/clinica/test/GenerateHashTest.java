package co.edu.uniquindio.clinica.test;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateHashTest {
    @Test
    public void generate() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.err.println("HASH_GENERATED: " + encoder.encode("password123"));
    }
}
