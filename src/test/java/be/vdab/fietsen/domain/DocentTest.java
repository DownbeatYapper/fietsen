package be.vdab.fietsen.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DocentTest {
    private final static BigDecimal WEDDE = BigDecimal.valueOf(200);
    private Docent docent1;
    @BeforeEach
    void beforeEach() {
        docent1 = new Docent("test", "test", WEDDE, "test@test.be", Geslacht.MAN);
    }
    @Test
    void opslag() {
        docent1.opslag(BigDecimal.TEN);
        assertThat(docent1.getWedde()).isEqualByComparingTo("220");
    }
    @Test
    void opslagMetNullMislukt() {
        assertThatNullPointerException().isThrownBy(() ->
                docent1.opslag(null));
    }
    @Test
    void opslagMet0Mislukt() {
        assertThatIllegalArgumentException().isThrownBy( () ->
                docent1.opslag(BigDecimal.ZERO));
    }
    @Test
    void negatieveOpslagMislukt() {
        assertThatIllegalArgumentException().isThrownBy( () ->
                docent1.opslag(BigDecimal.valueOf(-1)));
    }
}