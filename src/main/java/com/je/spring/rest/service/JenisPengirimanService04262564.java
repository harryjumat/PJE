/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
1711502664 - Habiburrahman Ahmadi
*/

package com.je.spring.rest.service;
import java.util.List;
import com.je.spring.rest.model.JenisPengiriman04262564;
/**
 *
 * @author Bib_
 */
public interface JenisPengirimanService04262564 {
    public List<JenisPengiriman04262564> getAll();
    public JenisPengiriman04262564 getById(int id);
    public long count();
    public void insert(JenisPengiriman04262564 jenisPengiriman);
    public void update(JenisPengiriman04262564 jenisPengiriman);
    public void delete(JenisPengiriman04262564 jenisPengiriman);
}
