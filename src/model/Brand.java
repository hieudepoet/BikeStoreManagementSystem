package model;

public class Brand {
    private String bcode;
    private String bname;
    private String country;
    
    public Brand(String bcode, String bname, String country) {
        this.bcode = bcode;
        this.bname = bname;
        this.country = country;
    }

    public String getBcode() {
        return bcode;
    }

    public String getBname() {
        return bname;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return getBcode() + ", " + getBname() + ", " + country;
    }
}
