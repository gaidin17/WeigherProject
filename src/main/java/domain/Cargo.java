package domain;

/**
 * Created by Gaidin on 12.11.2017.
 */
public class Cargo {
    private long id;
    private String type;

    public String getType() {

        return type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
