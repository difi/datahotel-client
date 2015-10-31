# Datahotel client

## Getting started

Include dependency in your pom.xml:

```xml
<dependency>
	<groupId>no.difi.commons</groupId>
	<artifactId>commons-datahotel</artifactId>
	<version>0.9.0</version>
</dependency>
```

Start fetching data:

```java
// Build client for municipalities
Datahotel<DifiGeoKommune> datahotel = DatahotelBuilder.create(DifiGeoKommune.class).build();

// Find all minicipalities starting with "Os" in name
Result result = datahotel.search("Os*").fetch();

// List municipalities found in search
for (DifiGeoKommune municipality : result) {
	System.out.println(municipality.getNavn());
}

// Loop all municipalities in data set
for (DifiGeoKommune municipality : datahotel) {
	System.out.println(municipality.getNavn());
}
```

## Query datahotel using your own classes

Want to make queries for counties?

```java
// Create class
// Please note setters are needed when using looping whole data set.
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
Datahotel<DifiGeoFylke> datahotel = DatahotelBuilder.create(DifiGeoFylke.class).build();

// List all counties:
for (DifiGeoFylke county : datahotel.fetch()) {
	System.out.println(String.format("%s: %s", county.getNummer(), county.getNavn()));
}

// Print name of county number 14
Result result = datahotel.field("nummer", "14").fetch();
System.out.println(result.get(0).getNavn());
```