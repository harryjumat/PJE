package com.je.spring.rest.dao.impl;

import com.je.spring.rest.model.Pengirim04262564;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.dao.PengirimDao04262564;

@Repository("PengirimDao")
public class PengirimDaoImpl04262564 implements PengirimDao04262564 {
    
    private static final String SQL_INSERT_PENGIRIM = "INSERT INTO PENGIRIM (nip_pengirim04262564,nama_pengirim04262564,telp_pengirim04262564,email_pengirim04262564,alamat_pengirim04262564) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_PENGIRIM = "UPDATE PENGIRIM SET nama_pengirim04262564=?, telp_pengirim04262564=?, email_pengirim04262564=?, alamat_pengirim04262564=? WHERE nip_pengirim04262564=?";
    private static final String SQL_DELETE_PENGIRIM = "DELETE FROM PENGIRIM WHERE nip_pengirim04262564=?";
    private static final String SQL_SELECT_PENGIRIM_BY_ID = "SELECT nip_pengirim04262564,nama_pengirim04262564,telp_pengirim04262564,email_pengirim04262564,alamat_pengirim04262564 FROM PENGIRIM WHERE nip_pengirim04262564=?";
    private static final String SQL_SELECT_PENGIRIM_ALL = "SELECT nip_pengirim04262564,nama_pengirim04262564,telp_pengirim04262564,email_pengirim04262564,alamat_pengirim04262564 FROM PENGIRIM";
    private static final String SQL_COUNT_PENGIRIM = "SELECT COUNT(*) FROM PENGIRIM";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pengirim04262564> getAll() {
        List<Pengirim04262564> PengirimList = null;
        try{
            PengirimList = jdbcTemplate.query(SQL_SELECT_PENGIRIM_ALL, new Object[]{},
                    new BeanPropertyRowMapper(Pengirim04262564.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return PengirimList;
    }

    @Override
    public Pengirim04262564 getById(int id) {
        Pengirim04262564 Pengirim = null;
        try{
            Pengirim = (Pengirim04262564) jdbcTemplate.queryForObject(SQL_SELECT_PENGIRIM_BY_ID, new Object[]{id},
                        new RowMapper<Pengirim04262564>(){
                        @Override
                        public Pengirim04262564 mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                Pengirim04262564 Pengirim = new Pengirim04262564();
                                                Pengirim.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                                                Pengirim.setNama_pengirim04262564(rs.getString("nama_pengirim04262564"));
                                                Pengirim.setTelp_pengirim04262564(rs.getString("telp_pengirim04262564"));
                                                Pengirim.setEmail_pengirim04262564(rs.getString("email_pengirim04262564"));
                                                Pengirim.setAlamat_pengirim04262564(rs.getString("alamat_pengirim04262564"));
                                                
                                                return Pengirim;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return Pengirim;
    }

    @Override
    public long count() {
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_PENGIRIM, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }

    @Override
    public void insert(Pengirim04262564 Pengirim) {
        try{
            jdbcTemplate.update(SQL_INSERT_PENGIRIM, new Object[]{Pengirim.getNip_pengirim04262564(),Pengirim.getNama_pengirim04262564(),Pengirim.getTelp_pengirim04262564(),
                Pengirim.getEmail_pengirim04262564(),Pengirim.getAlamat_pengirim04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pengirim04262564 Pengirim) {
        try{
            jdbcTemplate.update(SQL_UPDATE_PENGIRIM, new Object[]{Pengirim.getNama_pengirim04262564(),Pengirim.getTelp_pengirim04262564(),
                Pengirim.getEmail_pengirim04262564(),Pengirim.getAlamat_pengirim04262564(),Pengirim.getNip_pengirim04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Pengirim04262564 Pengirim) {
        try{
            jdbcTemplate.update(SQL_DELETE_PENGIRIM, new Object[]{Pengirim.getNip_pengirim04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
