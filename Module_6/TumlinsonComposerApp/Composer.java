/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_6.TumlinsonComposerApp;

public class Composer {
    private int id;
    private String genre;
    private String name;

    // the no arg constructor sets all to default
    Composer()
    {
        this.id = 0;
        this.genre = "";
        this.name = "";
    }

    // the arguement constructor sets all to the passed in values
    Composer(int id, String genre, String name)
    {
        this.id = id;
        this.genre = genre;
        this.name = name;
    }

    // gettters and setters for the Composer class are below
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    public String getGenre()
    {
        return this.genre;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("\n  Id: %d\n  Name: %s\n  Genre: %s", this.id, this.name, this.genre);
    }

}
