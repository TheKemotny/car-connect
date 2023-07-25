package pl.sda.carconnect.domain.enumeration;

public enum EngineType {
    V8 ("V8"),
    V6 ("V6"),
    ELECTRIC("ELECTRIC");

    private final String name;

    EngineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
