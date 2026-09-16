package br.com.fasda1973.taxcalculator.controller;

import br.com.fasda1973.taxcalculator.service.TaxService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tax")
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping("/iss")
    public double getIss(@RequestParam double amount) {
        return taxService.calculateIss(amount);
    }

    @GetMapping("/irpf")
    public double getIrpf(@RequestParam double amount) {
        return taxService.calculateIrmp(amount);
    }
}