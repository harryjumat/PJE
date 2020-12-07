/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.dao;

import com.je.spring.rest.model.TrackPaket04262564;
import java.util.List;

/**
 *
 * @author Bib_
 */
public interface TrackPaketDao04262564 {
    public List<TrackPaket04262564>getAll();
    public TrackPaket04262564 getById(String id);
    public long count();
    public void insert(TrackPaket04262564 trackPaket);
    public void update(TrackPaket04262564 trackPaket);
    public void delete(TrackPaket04262564 trackPaket);
}
