package my.nasa.test.dto;

public class Photo {
    private String img_src;
    private String id;
    private Rover rover;
    private Camera camera;
    private String sol;
    private String earth_date;

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getSol() {
        return sol;
    }

    public void setSol(String sol) {
        this.sol = sol;
    }

    public String getEarth_date() {
        return earth_date;
    }

    public void setEarth_date(String earth_date) {
        this.earth_date = earth_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (img_src != null ? !img_src.equals(photo.img_src) : photo.img_src != null) return false;
        if (!id.equals(photo.id)) return false;
        if (rover != null ? !rover.equals(photo.rover) : photo.rover != null) return false;
        if (camera != null ? !camera.equals(photo.camera) : photo.camera != null) return false;
        if (sol != null ? !sol.equals(photo.sol) : photo.sol != null) return false;
        return earth_date != null ? earth_date.equals(photo.earth_date) : photo.earth_date == null;

    }

    @Override
    public int hashCode() {
        int result = img_src != null ? img_src.hashCode() : 0;
        result = 31 * result + id.hashCode();
        result = 31 * result + (rover != null ? rover.hashCode() : 0);
        result = 31 * result + (camera != null ? camera.hashCode() : 0);
        result = 31 * result + (sol != null ? sol.hashCode() : 0);
        result = 31 * result + (earth_date != null ? earth_date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[img_src = " + img_src + ", id = " + id + ", rover = " + rover + ", camera = " + camera + ", sol = " +
                sol + ", earth_date = " + earth_date + "]";
    }
}