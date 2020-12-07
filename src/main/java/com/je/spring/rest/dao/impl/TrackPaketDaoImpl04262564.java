/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.dao.impl;

import com.je.spring.rest.dao.TrackPaketDao04262564;
import com.je.spring.rest.model.TrackPaket04262564;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bib_
 */
@Repository("trackPaketDao")
public class TrackPaketDaoImpl04262564 implements TrackPaketDao04262564 {
    private static final String SQL_INSERT_TRACK = "INSERT INTO TRACK_PAKET (nomor_resi04262564, kode_cabang04262564,nip_pengirim04262564,keterangan04262564,lokasi04262564) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_TRACK = "UPDATE TRACK_PAKET SET kode_cabang04262564=?, nip_pengirim04262564=?, keterangan04262564=?, lokasi04262564=? WHERE nomor_resi04262564=?";
    private static final String SQL_DELETE_TRACK = "DELETE FROM TRACK_PAKET WHERE nomor_resi04262564=?";
    private static final String SQL_SELECT_TRACK_BY_ID = "SELECT nomor_resi04262564,kode_cabang04262564,nip_pengirim04262564,keterangan04262564,lokasi04262564 FROM TRACK_PAKET WHERE nomor_resi04262564=?";
    private static final String SQL_SELECT_TRACK_ALL = "SELECT nomor_resi04262564,kode_cabang04262564,nip_pengirim04262564,keterangan04262564,lokasi04262564 FROM TRACK_PAKET";
    private static final String SQL_COUNT_TRACK = "SELECT COUNT(*) FROM TRACK_PAKET";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TrackPaket04262564> getAll() {
        List<TrackPaket04262564> trackPaketList = null;
        try{
            trackPaketList = jdbcTemplate.query(SQL_SELECT_TRACK_ALL, new Object[]{},
                    new BeanPropertyRowMapper(TrackPaket04262564.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return trackPaketList;
    }

    @Override
    public TrackPaket04262564 getById(String id) {
        TrackPaket04262564 trackPaket = null;
        try{
            trackPaket = (TrackPaket04262564) jdbcTemplate.queryForObject(SQL_SELECT_TRACK_BY_ID, new Object[]{id},
                        new RowMapper<TrackPaket04262564>(){
                        @Override
                        public TrackPaket04262564 mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                TrackPaket04262564 trackPaket = new TrackPaket04262564();
                                                trackPaket.setNomor_resi04262564(rs.getString("nomor_resi04262564"));
                                                trackPaket.setKode_cabang04262564(rs.getInt("kode_cabang04262564"));
                                                trackPaket.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                                                trackPaket.setKeterangan04262564(rs.getString("keterangan04262564"));
                                                trackPaket.setLokasi04262564(rs.getString("lokasi04262564"));
                                                
                                                return trackPaket;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return trackPaket;
    }

    @Override
    public long count() {
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_TRACK, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }

    @Override
    public void insert(TrackPaket04262564 trackPaket) {
        try{
            jdbcTemplate.update(SQL_INSERT_TRACK, new Object[]{trackPaket.getNomor_resi04262564(),trackPaket.getKode_cabang04262564(),trackPaket.getNip_pengirim04262564(),
                trackPaket.getKeterangan04262564(),trackPaket.getLokasi04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(TrackPaket04262564 trackPaket) {
        try{
            jdbcTemplate.update(SQL_UPDATE_TRACK, new Object[]{trackPaket.getKode_cabang04262564(),trackPaket.getNip_pengirim04262564(),
                trackPaket.getKeterangan04262564(),trackPaket.getLokasi04262564(), trackPaket.getNomor_resi04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(TrackPaket04262564 trackPaket) {
        try{
            jdbcTemplate.update(SQL_DELETE_TRACK, new Object[]{trackPaket.getNomor_resi04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
