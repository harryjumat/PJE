/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.service.impl;

import com.je.spring.rest.dao.TrackPaketDao04262564;
import com.je.spring.rest.model.TrackPaket04262564;
import com.je.spring.rest.service.TrackPaketService04262564;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bib_
 */
@Service("trackPaketService")
public class TrackPaketServiceImpl04262564 implements TrackPaketService04262564 {
    
    @Autowired
    TrackPaketDao04262564 trackPaketDao;
    
    @Override
    public List<TrackPaket04262564> getAll() {
        List<TrackPaket04262564> trackPaketList = new ArrayList<TrackPaket04262564>();
        trackPaketList = trackPaketDao.getAll();
        return trackPaketList;
    }

    @Override
    public TrackPaket04262564 getById(String id) {
        TrackPaket04262564 trackPaket = new TrackPaket04262564();
        trackPaket = trackPaketDao.getById(id);
        return trackPaket;
    }

    @Override
    public long count() {
        return trackPaketDao.count();
    }

    @Override
    public void insert(TrackPaket04262564 trackPaket) {
        trackPaketDao.insert(trackPaket);
    }

    @Override
    public void update(TrackPaket04262564 trackPaket) {
        trackPaketDao.update(trackPaket);
    }

    @Override
    public void delete(TrackPaket04262564 trackPaket) {
        trackPaketDao.delete(trackPaket);
    }
    
    
}
