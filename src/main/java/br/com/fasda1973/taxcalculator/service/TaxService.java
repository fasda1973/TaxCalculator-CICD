package br.com.fasda1973.taxcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    // Regras de negócio simples para impostos
    public double calculateIss(double amount) {
        validateAmount(amount);
        return amount * 0.05; // 5% de ISS
    }

    public double calculateIrmp(double amount) {
        validateAmount(amount);
        if (amount <= 2000) {
            return 0.0;
        }
        return amount * 0.15; // 15% de imposto para valores acima de 2000
    }

    private void validateAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("O valor base nao pode ser negativo");
        }
    }
}