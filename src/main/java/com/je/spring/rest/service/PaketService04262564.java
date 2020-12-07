/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.service;

import java.util.List;
import com.je.spring.rest.model.Paket04262564;
/**
 *
 * @author bowid
 */
public interface PaketService04262564 {
    public List<Paket04262564> getAll();
    public Paket04262564 getById(int id);
    public long count();
    public void insert(Paket04262564 paket);
    public void update(Paket04262564 paket);
    public void delete(Paket04262564 paket);
}

