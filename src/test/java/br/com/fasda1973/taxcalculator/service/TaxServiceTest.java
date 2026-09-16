package br.com.fasda1973.taxcalculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaxServiceTest {

    private TaxService taxService;

    @BeforeEach
    void setUp() {
        taxService = new TaxService();
    }

    @Test
    void shouldCalculateIssCorrectly() {
        double result = taxService.calculateIss(1000.0);
        assertEquals(99.0, result, 0.001);
    }

    @Test
    void shouldReturnZeroIrpfForLowAmount() {
        double result = taxService.calculateIrmp(1500.0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldCalculateIrpfForHighAmount() {
        double result = taxService.calculateIrmp(3000.0);
        assertEquals(450.0, result, 0.001);
    }

    @Test
    void shouldThrowExceptionForNegativeAmount() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> taxService.calculateIss(-100.0)
        );
        assertEquals("O valor base nao pode ser negativo", exception.getMessage());
    }
}