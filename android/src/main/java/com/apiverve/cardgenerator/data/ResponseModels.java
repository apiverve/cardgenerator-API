// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     CardGeneratorData data = Converter.fromJsonString(jsonString);

package com.apiverve.cardgenerator.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static CardGeneratorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(CardGeneratorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(CardGeneratorData.class);
        writer = mapper.writerFor(CardGeneratorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// CardGeneratorData.java

package com.apiverve.cardgenerator.data;

import com.fasterxml.jackson.annotation.*;

public class CardGeneratorData {
    private String brand;
    private long count;
    private Card[] cards;
    private Owner owner;

    @JsonProperty("brand")
    public String getBrand() { return brand; }
    @JsonProperty("brand")
    public void setBrand(String value) { this.brand = value; }

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("cards")
    public Card[] getCards() { return cards; }
    @JsonProperty("cards")
    public void setCards(Card[] value) { this.cards = value; }

    @JsonProperty("owner")
    public Owner getOwner() { return owner; }
    @JsonProperty("owner")
    public void setOwner(Owner value) { this.owner = value; }
}

// Card.java

package com.apiverve.cardgenerator.data;

import com.fasterxml.jackson.annotation.*;
import java.util.UUID;

public class Card {
    private long cvv;
    private String issuer;
    private UUID id;
    private String number;
    private String expiration;
    private String brand;
    private NumberAlt numberAlt;

    @JsonProperty("cvv")
    public long getCvv() { return cvv; }
    @JsonProperty("cvv")
    public void setCvv(long value) { this.cvv = value; }

    @JsonProperty("issuer")
    public String getIssuer() { return issuer; }
    @JsonProperty("issuer")
    public void setIssuer(String value) { this.issuer = value; }

    @JsonProperty("id")
    public UUID getID() { return id; }
    @JsonProperty("id")
    public void setID(UUID value) { this.id = value; }

    @JsonProperty("number")
    public String getNumber() { return number; }
    @JsonProperty("number")
    public void setNumber(String value) { this.number = value; }

    @JsonProperty("expiration")
    public String getExpiration() { return expiration; }
    @JsonProperty("expiration")
    public void setExpiration(String value) { this.expiration = value; }

    @JsonProperty("brand")
    public String getBrand() { return brand; }
    @JsonProperty("brand")
    public void setBrand(String value) { this.brand = value; }

    @JsonProperty("number_alt")
    public NumberAlt getNumberAlt() { return numberAlt; }
    @JsonProperty("number_alt")
    public void setNumberAlt(NumberAlt value) { this.numberAlt = value; }
}

// NumberAlt.java

package com.apiverve.cardgenerator.data;

import com.fasterxml.jackson.annotation.*;

public class NumberAlt {
    private String masked;
    private String unmasked;
    private String last4;

    @JsonProperty("masked")
    public String getMasked() { return masked; }
    @JsonProperty("masked")
    public void setMasked(String value) { this.masked = value; }

    @JsonProperty("unmasked")
    public String getUnmasked() { return unmasked; }
    @JsonProperty("unmasked")
    public void setUnmasked(String value) { this.unmasked = value; }

    @JsonProperty("last4")
    public String getLast4() { return last4; }
    @JsonProperty("last4")
    public void setLast4(String value) { this.last4 = value; }
}

// Owner.java

package com.apiverve.cardgenerator.data;

import com.fasterxml.jackson.annotation.*;

public class Owner {
    private String name;
    private Address address;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("address")
    public Address getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(Address value) { this.address = value; }
}

// Address.java

package com.apiverve.cardgenerator.data;

import com.fasterxml.jackson.annotation.*;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    @JsonProperty("street")
    public String getStreet() { return street; }
    @JsonProperty("street")
    public void setStreet(String value) { this.street = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("state")
    public String getState() { return state; }
    @JsonProperty("state")
    public void setState(String value) { this.state = value; }

    @JsonProperty("zipCode")
    public String getZipCode() { return zipCode; }
    @JsonProperty("zipCode")
    public void setZipCode(String value) { this.zipCode = value; }
}