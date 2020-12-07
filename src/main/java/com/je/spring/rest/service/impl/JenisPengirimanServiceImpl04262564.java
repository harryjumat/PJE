/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
1711502664 - Habiburrahman Ahmadi
*/

package com.je.spring.rest.service.impl;

import com.je.spring.rest.model.JenisPengiriman04262564;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.dao.JenisPengirimanDao04262564;
import com.je.spring.rest.service.JenisPengirimanService04262564;
/**
 *
 * @author Bib_
 */
@Service("jenisPengirimanService")
public class JenisPengirimanServiceImpl04262564 implements JenisPengirimanService04262564 {
    
    @Autowired
    JenisPengirimanDao04262564 jenisPengirimanDao;
    
    @Override
    public List<JenisPengiriman04262564> getAll() {
        List<JenisPengiriman04262564> jenisPengirimanList = new ArrayList<JenisPengiriman04262564>();
        jenisPengirimanList = jenisPengirimanDao.getAll();
        return jenisPengirimanList;
    }

    @Override
    public JenisPengiriman04262564 getById(int id) {
        JenisPengiriman04262564 jenisPengiriman = new JenisPengiriman04262564();
        jenisPengiriman = jenisPengirimanDao.getById(id);
        return jenisPengiriman;
    }

    @Override
    public long count() {
        return jenisPengirimanDao.count();
    }

    @Override
    public void insert(JenisPengiriman04262564 jenisPengiriman) {
        jenisPengirimanDao.insert(jenisPengiriman);
    }

    @Override
    public void update(JenisPengiriman04262564 jenisPengiriman) {
        jenisPengirimanDao.update(jenisPengiriman);
    }

    @Override
    public void delete(JenisPengiriman04262564 jenisPengiriman) {
        jenisPengirimanDao.delete(jenisPengiriman);
    }
    
    
}
