/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.service.impl;

import com.je.spring.rest.model.Paket04262564;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.dao.PaketDao04262564;
import com.je.spring.rest.service.PaketService04262564;
/**
 *
 * @author bowid
 */
@Service("paketService")
public class PaketServiceImpl04262564 implements PaketService04262564 {
    
    @Autowired
    PaketDao04262564 paketDao;
    
    @Override
    public List<Paket04262564> getAll(){
        List<Paket04262564> paketList = new ArrayList<Paket04262564>();
        paketList = paketDao.getAll();
        return paketList;
    }
    
    @Override
    public Paket04262564 getById(int id){
        Paket04262564 paket = new Paket04262564();
        paket = paketDao.getById(id);
        return paket;
    }
    
    @Override
    public long count() {
        return paketDao.count();
    }

    @Override
    public void insert(Paket04262564 paket) {
        paketDao.insert(paket);
    }

    @Override
    public void update(Paket04262564 paket) {
        paketDao.update(paket);
    }

    @Override
    public void delete(Paket04262564 paket) {
        paketDao.delete(paket);
    }
    
}