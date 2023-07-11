package com.bollettino.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	private static final String CODICE_CONTO_CORRENTE_REGEX = "^\\d{6}$";
    private static final String CODICE_BOLLETTINO_REGEX = "^[a-zA-Z0-9]{18}$";
    private static final String CAUSALE_REGEX = "^[\\p{L}\\p{N}\\p{P}\\p{S}\\p{Z}]{0,255}$";
    private static final String IMPORTO_REGEX = "^\\d{1,6}[.,]\\d{2}?$";
    private static final String NOME_REGEX = "[A-Za-z\\s-]{2,}";
    private static final String COGNOME_REGEX = "[A-Za-z\\s-]{2,}";
    private static final String NUMERO_CARTA_REGEX = "^(?:\\d[ -]*?){13,16}$";
    
    public boolean validateCodiceContoCorrente(String codiceContoCorrente) {
        return codiceContoCorrente.matches(CODICE_CONTO_CORRENTE_REGEX);
    }

    public boolean validateCodiceBollettino(String codiceBollettino) {
        return codiceBollettino.matches(CODICE_BOLLETTINO_REGEX);
    }

    public boolean validateCausale(String causale) {
        return causale.matches(CAUSALE_REGEX);
    }

    public boolean validateImporto(double importo) {
        return String.valueOf(importo).matches(IMPORTO_REGEX);
    }
    
    public boolean validateNomePagatore(String nomePagatore) {
    	return String.valueOf(nomePagatore).matches(NOME_REGEX);
    }
    
    public boolean validateCognomePagatore(String cognomePagatore) {
    	return String.valueOf(cognomePagatore).matches(COGNOME_REGEX);
    }
    
    public boolean validateNumeroCarta(long numeroCarta) {
    	return String.valueOf(numeroCarta).matches(NUMERO_CARTA_REGEX);
    }
}
