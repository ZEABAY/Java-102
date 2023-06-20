public class Team {
    private String name;
    private int ID;

    public Team(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }


    ////////// Getter and Setter /////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
