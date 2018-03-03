package my.nasa.test.dto;

public class Camera {
    private String id;
    private String name;
    private String full_name;
    private String rover_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRover_id() {
        return rover_id;
    }

    public void setRover_id(String rover_id) {
        this.rover_id = rover_id;
    }

    @Override
    public String toString() {
        return "[id = " + id + ", name = " + name + ", full_name = " + full_name + ", rover_id = " + rover_id + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Camera camera = (Camera) o;

        if (id != null ? !id.equals(camera.id) : camera.id != null) return false;
        if (!name.equals(camera.name)) return false;
        if (!full_name.equals(camera.full_name)) return false;
        return rover_id != null ? rover_id.equals(camera.rover_id) : camera.rover_id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + full_name.hashCode();
        result = 31 * result + (rover_id != null ? rover_id.hashCode() : 0);
        return result;
    }
}
