package my.nasa.test.dto;

import java.util.Arrays;

public class Rover {
    private String id;
    private String max_date;
    private String landing_date;
    private String launch_date;
    private String status;
    private String name;
    private String max_sol;
    private String total_photos;
    private Camera[] cameras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMax_date() {
        return max_date;
    }

    public void setMax_date(String max_date) {
        this.max_date = max_date;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public void setLanding_date(String landing_date) {
        this.landing_date = landing_date;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMax_sol() {
        return max_sol;
    }

    public void setMax_sol(String max_sol) {
        this.max_sol = max_sol;
    }

    public String getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(String total_photos) {
        this.total_photos = total_photos;
    }

    public Camera[] getCameras() {
        return cameras;
    }

    public void setCameras(Camera[] cameras) {
        this.cameras = cameras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (!id.equals(rover.id)) return false;
        if (max_date != null ? !max_date.equals(rover.max_date) : rover.max_date != null) return false;
        if (landing_date != null ? !landing_date.equals(rover.landing_date) : rover.landing_date != null) return false;
        if (launch_date != null ? !launch_date.equals(rover.launch_date) : rover.launch_date != null) return false;
        if (status != null ? !status.equals(rover.status) : rover.status != null) return false;
        if (!name.equals(rover.name)) return false;
        if (max_sol != null ? !max_sol.equals(rover.max_sol) : rover.max_sol != null) return false;
        if (total_photos != null ? !total_photos.equals(rover.total_photos) : rover.total_photos != null) return false;
        // Not sure re-test - would fail if cameras are in different orders within arrays
        return Arrays.equals(cameras, rover.cameras);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (max_date != null ? max_date.hashCode() : 0);
        result = 31 * result + (landing_date != null ? landing_date.hashCode() : 0);
        result = 31 * result + (launch_date != null ? launch_date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + (max_sol != null ? max_sol.hashCode() : 0);
        result = 31 * result + (total_photos != null ? total_photos.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(cameras);
        return result;
    }

    @Override
    public String toString() {
        return "[id = " + id + ", max_date = " + max_date + ", landing_date = " + landing_date + ", launch_date = " +
                launch_date + ", status = " + status + ", name = " + name + ", max_sol = " + max_sol + ", total_photos = " +
                total_photos + ", cameras = " + cameras + "]";

    }
}
