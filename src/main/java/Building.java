public class Building {
    String blName, city, FoundationYear;

    public Building(String blName, String city, String foundationYear) {
        this.blName = blName;
        this.city = city;
        FoundationYear = foundationYear;
    }

    public String getBlName() {
        return blName;
    }

    public String getCity() {
        return city;
    }

    public String getFoundationYear() {
        return FoundationYear;
    }

    public void setBlName(String blName) {
        this.blName = blName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFoundationYear(String foundationYear) {
        FoundationYear = foundationYear;
    }
}

