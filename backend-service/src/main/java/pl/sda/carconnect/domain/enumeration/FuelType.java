package pl.sda.carconnect.domain.enumeration;

public enum FuelType {
    LPG ("LPG"),
    DIESEL("DIESEL"),
    GASOLINE("GASOLINE"),
    ELECTRIC("ELECTRIC"),
    BIODIESEL("BIODIESEL");



    public String getFuelDescription() {
        return fuelDescription;
    }

    FuelType(final String fuelDescription) {
        this.fuelDescription = fuelDescription;
    }

    private final String fuelDescription;
}
