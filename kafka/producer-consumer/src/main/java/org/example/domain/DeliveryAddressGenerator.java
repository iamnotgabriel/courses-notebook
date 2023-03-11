package org.example.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DeliveryAddressGenerator {

    private static final String[] addressLines = {
            "Rua Antonio Palmeira, numero 14, Bairro Vila dos Fundadores",
            "Rua Batman, numero 90, Bairro Campo dos heróis",
            "Rua dos bobos, numero 0",
            "Rua São Paulo, numero 26, Bairro Brasil",
            "Rua Brasil, numero 10, Bairro Terra",
    };
    private static final String[] cities = {
            "São João Lá Longe",
            "Cidade Pequena",
            "Fortaleza de Minas Gerais",
            "Cafundó",
            "Pina",
    };
    private static final String[] states= {
            "Rio de Janeiro",
            "Minas Gerais",
            "Amazonas",
            "Santa Catarina",
            "Alagoas",
    };
    private static final String[] contactNumbers = {
            "44028922",
            "33332222",
            "98123123",
            "98765432",
            "65758419",
    };
    private static final String[] pinCodes = {
            "0000-000",
            "1234-987",
            "9876-012",
            "9098-123",
            "3321-987",
    };

    private final ThreadLocalRandom random;

    public DeliveryAddressGenerator() {
        this.random = ThreadLocalRandom.current();
    }

    public DeliveryAddress next() {
        DeliveryAddress address  = new DeliveryAddress();
        address.setAddressLine(addressLines[randomIndex()]);
        address.setCity(cities[randomIndex()]);
        address.setContactNumber(contactNumbers[randomIndex()]);
        address.setState(states[randomIndex()]);
        address.setPinCode(pinCodes[randomIndex()]);

        return address;
    }

    private int randomIndex() {
        return random.nextInt(0, 5);
    }
}
