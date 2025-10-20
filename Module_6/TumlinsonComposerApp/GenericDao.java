/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

package Module_6.TumlinsonComposerApp;

import java.util.List;

public interface GenericDao <E, K> {
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);
}
