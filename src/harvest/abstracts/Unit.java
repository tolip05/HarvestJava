package harvest.abstracts;

public abstract class Unit {
    private String id;

    public Unit(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }
    public abstract String getType();
}
