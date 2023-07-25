package pl.sda.carconnect.domain.enumeration;

public enum BodyType {
    SEDAN ("SEDAN"),
    SUV("SUV"),
    COUPE("COUPE"),
    HATCHBACK("HATCHBACK"),
    SUPERCAR("SUPERCAR"),
    VAN("VAN"),
    PICKUP("PICKUP");

    private final String name;

    BodyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
