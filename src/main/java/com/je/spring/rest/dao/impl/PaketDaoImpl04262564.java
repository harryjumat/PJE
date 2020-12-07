/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.dao.impl;

import com.je.spring.rest.dao.PaketDao04262564;
import com.je.spring.rest.model.JenisPengiriman04262564;
import com.je.spring.rest.model.Paket04262564;
import com.je.spring.rest.model.Pengirim04262564;
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
 * @author bowid
 */
@Repository("paketDao")
public class PaketDaoImpl04262564 implements PaketDao04262564{
    
    private static final String SQL_INSERT_PAKET = "INSERT INTO PAKET (id_paket04262564, id_kurir_service04262564, nip_pengirim04262564, nomor_resi04262564, order_id04262564, alamat_paket04262564, penerima04262564, service04262564) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_PAKET = "UPDATE PAKET SET id_kurir_service04262564=?, nip_pengirim04262564=?, nomor_resi04262564=?, order_id04262564=?, alamat_paket04262564=?, penerima04262564=?, service04262564=? WHERE id_paket04262564=?";
    private static final String SQL_DELETE_PAKET = "DELETE FROM PAKET WHERE id_paket04262564=?";
    private static final String SQL_SELECT_PAKET_BY_ID = "SELECT paket.*, pengirim.*, service.*, track_paket.* FROM PAKET INNER JOIN SERVICE ON service.id_kurir_service04262564 = paket.id_kurir_service04262564 INNER JOIN PENGIRIM ON pengirim.nip_pengirim04262564 = paket.nip_pengirim04262564 INNER JOIN TRACK_PAKET ON track_paket.nomor_resi04262564 = paket.nomor_resi04262564 WHERE paket.id_paket04262564=?";
    private static final String SQL_SELECT_PAKET_ALL = "SELECT paket.*, pengirim.*, service.*, track_paket.* FROM PAKET INNER JOIN SERVICE ON service.id_kurir_service04262564 = paket.id_kurir_service04262564 INNER JOIN PENGIRIM ON pengirim.nip_pengirim04262564 = paket.nip_pengirim04262564 INNER JOIN TRACK_PAKET ON track_paket.nomor_resi04262564 = paket.nomor_resi04262564";
    private static final String SQL_COUNT_PAKET = "SELECT COUNT(*) FROM PAKET INNER JOIN SERVICE ON service.id_kurir_service04262564 = paket.id_kurir_service04262564"
                                                  + "INNER JOIN PENGIRIM ON pengirim.nip_pengirim04262564 = paket.nip_pengirim04262564"
                                                  + "INNER JOIN TRACK_PAKET ON track_paket.nomor_resi04262564 = paket.nomor_resi04262564";
    
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Paket04262564> getAll(){
        List<Paket04262564> paketList = null;
        try{
            
            paketList = jdbcTemplate.query(SQL_SELECT_PAKET_ALL, new Object[]{}, new RowMapper<Paket04262564>(){
                @Override
                public Paket04262564 mapRow(ResultSet rs, int rowNum)throws SQLException{
                    Paket04262564 paket = new Paket04262564();
                    JenisPengiriman04262564 jenisPengiriman = new JenisPengiriman04262564();
                    Pengirim04262564    Pengirim = new Pengirim04262564();
                    TrackPaket04262564  trackPaket = new TrackPaket04262564();
                    
                    paket.setId_paket04262564(rs.getInt("id_paket04262564"));
                    paket.setId_kurir_service04262564(rs.getInt("id_kurir_service04262564"));
                    paket.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                    paket.setNomor_resi04262564(rs.getString("nomor_resi04262564"));
                    paket.setAlamat_paket04262564(rs.getString("alamat_paket04262564"));
                    paket.setOrder_id04262564(rs.getInt("order_id04262564"));
                    paket.setPenerima04262564(rs.getString("penerima04262564"));
                    paket.setService04262564(rs.getString("service04262564"));
                    
                    jenisPengiriman.setId_kurir_service04262564(rs.getInt("id_kurir_service04262564"));
                    jenisPengiriman.setNama_service04262564(rs.getString("nama_service04262564"));
                    jenisPengiriman.setId_harga_service04262564(rs.getInt("harga_service04262564"));
                    jenisPengiriman.setLama_hari04262564(rs.getInt("lama_hari04262564"));
                    jenisPengiriman.setBerat_barang04262564(rs.getString("berat_barang04262564"));
                    paket.setJenisPengiriman04262564(jenisPengiriman);
                    
                    Pengirim.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                    Pengirim.setNama_pengirim04262564(rs.getString("nama_pengirim04262564"));
                    Pengirim.setTelp_pengirim04262564(rs.getString("telp_pengirim04262564"));
                    Pengirim.setEmail_pengirim04262564(rs.getString("email_pengirim04262564"));
                    Pengirim.setAlamat_pengirim04262564(rs.getString("alamat_pengirim04262564"));
                    paket.setPengirim04262564(Pengirim);
                    
                    trackPaket.setNomor_resi04262564(rs.getString("nomor_resi04262564"));
                    trackPaket.setKode_cabang04262564(rs.getInt("kode_cabang04262564"));
                    trackPaket.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                    trackPaket.setKeterangan04262564(rs.getString("keterangan04262564"));
                    trackPaket.setLokasi04262564(rs.getString("lokasi04262564"));
                    paket.setTrackPaket04262564(trackPaket);
                    
                    return paket;
                }
            });
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return paketList;
    }
    
    @Override
    public Paket04262564 getById(int id){
        Paket04262564 paket = null;
        try{
            
            paket = (Paket04262564) jdbcTemplate.queryForObject(SQL_SELECT_PAKET_BY_ID, new Object[]{id}, new RowMapper<Paket04262564>(){
                @Override
                public Paket04262564 mapRow(ResultSet rs, int rowNum)throws SQLException{
                    Paket04262564 paket = new Paket04262564();
                    JenisPengiriman04262564 jenisPengiriman = new JenisPengiriman04262564();
                    Pengirim04262564    Pengirim = new Pengirim04262564();
                    TrackPaket04262564  trackPaket = new TrackPaket04262564();
                    paket.setId_paket04262564(rs.getInt("id_paket04262564"));
                    paket.setId_kurir_service04262564(rs.getInt("id_kurir_service04262564"));
                    paket.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                    paket.setNomor_resi04262564(rs.getString("nomor_resi04262564"));
                    paket.setOrder_id04262564(rs.getInt("order_id04262564"));
                    paket.setAlamat_paket04262564(rs.getString("alamat_paket04262564"));
                    paket.setPenerima04262564(rs.getString("penerima04262564"));
                    paket.setService04262564(rs.getString("service04262564"));
                    
                    jenisPengiriman.setId_kurir_service04262564(rs.getInt("id_kurir_service04262564"));
                    jenisPengiriman.setNama_service04262564(rs.getString("nama_service04262564"));
                    jenisPengiriman.setId_harga_service04262564(rs.getInt("harga_service04262564"));
                    jenisPengiriman.setLama_hari04262564(rs.getInt("lama_hari04262564"));
                    jenisPengiriman.setBerat_barang04262564(rs.getString("berat_barang04262564"));
                    paket.setJenisPengiriman04262564(jenisPengiriman);
                    
                    Pengirim.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                    Pengirim.setNama_pengirim04262564(rs.getString("nama_pengirim04262564"));
                    Pengirim.setTelp_pengirim04262564(rs.getString("telp_pengirim04262564"));
                    Pengirim.setEmail_pengirim04262564(rs.getString("email_pengirim04262564"));
                    Pengirim.setAlamat_pengirim04262564(rs.getString("alamat_pengirim04262564"));
                    paket.setPengirim04262564(Pengirim);
                    
                    trackPaket.setNomor_resi04262564(rs.getString("nomor_resi04262564"));
                    trackPaket.setKode_cabang04262564(rs.getInt("kode_cabang04262564"));
                    trackPaket.setNip_pengirim04262564(rs.getInt("nip_pengirim04262564"));
                    trackPaket.setKeterangan04262564(rs.getString("keterangan04262564"));
                    trackPaket.setLokasi04262564(rs.getString("lokasi04262564"));
                    paket.setTrackPaket04262564(trackPaket);
                    
                    return paket;
                }
            });
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return paket;
    }
    
    @Override
    public long count() {
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_PAKET, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    @Override
    public void insert(Paket04262564 paket){
        try{
            jdbcTemplate.update(SQL_INSERT_PAKET, new Object[]{ paket.getId_paket04262564(), paket.getJenisPengiriman().getId_kurir_service04262564(), paket.getPengirim().getNip_pengirim04262564(), paket.getTrackPaket().getNomor_resi04262564(),
            paket.getOrder_id04262564(), paket.getAlamat_paket04262564(), paket.getPenerima04262564(), paket.getService04262564()});
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Paket04262564 paket){
        try{
            System.out.println(paket.getId_paket04262564());
            jdbcTemplate.update(SQL_UPDATE_PAKET, new Object[]{paket.getJenisPengiriman().getId_kurir_service04262564(), paket.getPengirim().getNip_pengirim04262564(), paket.getTrackPaket().getNomor_resi04262564(), paket.getOrder_id04262564(), paket.getAlamat_paket04262564(),
            paket.getPenerima04262564(), paket.getService04262564() , paket.getId_paket04262564()});
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Paket04262564 paket){
        try{
            jdbcTemplate.update(SQL_DELETE_PAKET, new Object[]{paket.getId_paket04262564()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
