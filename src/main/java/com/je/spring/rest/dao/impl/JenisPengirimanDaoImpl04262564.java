/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
1711502664 - Habiburrahman Ahmadi
*/

package com.je.spring.rest.dao.impl;
import com.je.spring.rest.model.JenisPengiriman04262564;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.dao.JenisPengirimanDao04262564;
/**
 *
 * @author Bib_
 */
@Repository("jenisPengirimanDao")
public class JenisPengirimanDaoImpl04262564 implements JenisPengirimanDao04262564 {
    
    private static final String SQL_INSERT_PENGIRIMAN = "INSERT INTO SERVICE (id_kurir_service04262564,nama_service04262564,harga_service04262564,lama_hari04262564,berat_barang04262564) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_PENGIRIMAN = "UPDATE SERVICE SET nama_service04262564=?, harga_service04262564=?, lama_hari04262564=?, berat_barang04262564=? WHERE id_kurir_service04262564=?";
    private static final String SQL_DELETE_PENGIRIMAN = "DELETE FROM SERVICE WHERE id_kurir_service04262564=?";
    private static final String SQL_SELECT_PENGIRIMAN_BY_ID = "SELECT id_kurir_service04262564,nama_service04262564,harga_service04262564,lama_hari04262564,berat_barang04262564 FROM SERVICE WHERE id_kurir_service04262564=?";
    private static final String SQL_SELECT_PENGIRIMAN_ALL = "SELECT id_kurir_service04262564,nama_service04262564,harga_service04262564,lama_hari04262564,berat_barang04262564 FROM SERVICE";
    private static final String SQL_COUNT_PENGIRIMAN = "SELECT COUNT(*) FROM SERVICE";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<JenisPengiriman04262564> getAll() {
        List<JenisPengiriman04262564> jenisPengirimanList = null;
        try{
            jenisPengirimanList = jdbcTemplate.query(SQL_SELECT_PENGIRIMAN_ALL, new Object[]{},
                    new BeanPropertyRowMapper(JenisPengiriman04262564.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return jenisPengirimanList;
    }

    @Override
    public JenisPengiriman04262564 getById(int id) {
        JenisPengiriman04262564 jenisPengiriman = null;
        try{
            jenisPengiriman = (JenisPengiriman04262564) jdbcTemplate.queryForObject(SQL_SELECT_PENGIRIMAN_BY_ID, new Object[]{id},
                        new RowMapper<JenisPengiriman04262564>(){
                        @Override
                        public JenisPengiriman04262564 mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                JenisPengiriman04262564 jenisPengiriman = new JenisPengiriman04262564();
                                                jenisPengiriman.setId_kurir_service04262564(rs.getInt("id_kurir_service04262564"));
                                                jenisPengiriman.setNama_service04262564(rs.getString("nama_service04262564"));
                                                jenisPengiriman.setId_harga_service04262564(rs.getInt("harga_service04262564"));
                                                jenisPengiriman.setLama_hari04262564(rs.getInt("lama_hari04262564"));
                                                jenisPengiriman.setBerat_barang04262564(rs.getString("berat_barang04262564"));
                                                
                                                return jenisPengiriman;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return jenisPengiriman;
    }

    @Override
    public long count() {
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_PENGIRIMAN, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }

    @Override
    public void insert(JenisPengiriman04262564 jenisPengiriman) {
        try{
            jdbcTemplate.update(SQL_INSERT_PENGIRIMAN, new Object[]{jenisPengiriman.getId_kurir_service04262564(),jenisPengiriman.getNama_service04262564(),jenisPengiriman.getId_harga_service04262564(),
                jenisPengiriman.getLama_hari04262564(),jenisPengiriman.getBerat_barang04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(JenisPengiriman04262564 jenisPengiriman) {
        try{
            jdbcTemplate.update(SQL_UPDATE_PENGIRIMAN, new Object[]{jenisPengiriman.getNama_service04262564(),jenisPengiriman.getId_harga_service04262564(),
                jenisPengiriman.getLama_hari04262564(),jenisPengiriman.getBerat_barang04262564(),jenisPengiriman.getId_kurir_service04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(JenisPengiriman04262564 jenisPengiriman) {
        try{
            jdbcTemplate.update(SQL_DELETE_PENGIRIMAN, new Object[]{jenisPengiriman.getId_kurir_service04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
