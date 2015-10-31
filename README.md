# Datahotel client

## Getting started

Include dependency in your pom.xml:

```xml
<dependency>
	<groupId>no.difi.datahotel</groupId>
	<artifactId>datahotel-client</artifactId>
	<version>0.9.0</version>
</dependency>
```

Start fetching data:

```java
// Build client for municipalities
Datahotel datahotel = DatahotelBuilder.create(DifiGeoKommune.class).build();

// Find all minicipalities starting with "Os" in name
Result result = datahotel.search("Os*").fetch();
```

## Query datahotel using your own classes

Want to make a queries for counties?

```java
// Create class
@Dataset("difi/geo/fylke")
public class DifiGeoFylke {
    private String nummer, navn;

    public String getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }
}

// Build client for municipalities
Datahotel datahotel = DatahotelBuilder.create(DifiGeoFylke.class).build();

// List all counties:
for (DifiGeoFylke county : (List<DifiGeoFylke>) datahotel.fetch()) {
	System.out.println(String.format("%s: %s", county.getNummer(), county.getNavn()));
}

// Print name of county number 14
Result result = datahotel.field("nummer", "14").fetch();
System.out.println(((DifiGeoFylke) result.get(0)).getNavn());
```