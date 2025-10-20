/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_6.TumlinsonComposerApp;

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao
{
    private List<Composer> composers = new ArrayList<>();

    // create a base composer list
    MemComposerDao()
    {
        insert(new Composer(1, "Classical", "Ludwig Van Beethoven"));
        insert(new Composer(2, "Classical", "Johann Sebastian Bach"));
        insert(new Composer(3, "Classical", "Wolfgang Amadeus Mozart"));
        insert(new Composer(4, "Classical", "Johannes Brahms"));
        insert(new Composer(5, "Classical", "Joseph Haydn"));
    }

    // override the required findAll function from ComposerDao
    @Override
    public List<Composer> findAll() {
        return this.composers;
    }

    // override the required findBy method from ComposerDao
    @Override
    public Composer findBy(Integer key){
        // search the composers for one with an ID that matches the key
        for(Composer comp : composers)
        {
            if(comp.getId() == key)
            {
                return comp;
            }
        }
        return new Composer();
    }

    // insert a new composer to the composers list
    @Override
    public void insert(Composer entity) {
        this.composers.add(entity);
    }

    
}
