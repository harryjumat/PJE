package com.je.spring.rest.service.impl;

import com.je.spring.rest.dao.PengirimDao04262564;
import com.je.spring.rest.model.Pengirim04262564;
import com.je.spring.rest.service.PengirimService04262564;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("PengirimService")
public class PengirimServiceImpl04262564 implements PengirimService04262564 {
    
     @Autowired
    PengirimDao04262564 PengirimDao;
    
    @Override
    public List<Pengirim04262564> getAll() {
        List<Pengirim04262564> PengirimList = new ArrayList<Pengirim04262564>();
        PengirimList = PengirimDao.getAll();
        return PengirimList;
    }

    @Override
    public Pengirim04262564 getById(int id) {
        Pengirim04262564 Pengirim = new Pengirim04262564();
        Pengirim = PengirimDao.getById(id);
        return Pengirim;
    }

    @Override
    public long count() {
        return PengirimDao.count();
    }

    @Override
    public void insert(Pengirim04262564 Pengirim) {
        PengirimDao.insert(Pengirim);
    }

    @Override
    public void update(Pengirim04262564 Pengirim) {
        PengirimDao.update(Pengirim);
    }

    @Override
    public void delete(Pengirim04262564 Pengirim) {
        PengirimDao.delete(Pengirim);
    }
}
