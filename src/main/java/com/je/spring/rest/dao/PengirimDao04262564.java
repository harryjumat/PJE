
package com.je.spring.rest.dao;

import com.je.spring.rest.model.Pengirim04262564;
import java.util.List;


public interface PengirimDao04262564 {
    
    public List<Pengirim04262564>getAll();
    public Pengirim04262564 getById(int id);
    public long count();
    public void insert(Pengirim04262564 Pengirim);
    public void update(Pengirim04262564 Pengirim);
    public void delete(Pengirim04262564 Pengirim);
}
