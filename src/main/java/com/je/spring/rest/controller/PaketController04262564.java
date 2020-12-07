/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.controller;

import com.je.spring.rest.service.PaketService04262564;
import com.je.spring.rest.service.JenisPengirimanService04262564;
import com.je.spring.rest.service.PengirimService04262564;
import com.je.spring.rest.service.TrackPaketService04262564;
import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import com.je.spring.rest.model.Paket04262564;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

/**
 *
 * @author bowid
 */
@Controller
public class PaketController04262564 {
    
    @Autowired
    private PaketService04262564 paketService;
    
    @Autowired
    private JenisPengirimanService04262564 jenisPengirimanService;
    
    @Autowired
    private PengirimService04262564 PengirimService;
    
    @Autowired
    private TrackPaketService04262564 trackPaketService;
    
    Gson gson = new Gson();
    
    @RequestMapping(value = "/master/paket04262564", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Paket04262564> paketList = paketService.getAll();
            long count = paketService.count();
            
            response.put(Constants.LIST, paketList);
            response.put(Constants.TOTAL, count);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/paket04262564/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            
            Paket04262564 paket = paketService.getById(id);
            
            response.put(Constants.PAKET04262564_KEY, paket);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/paket04262564", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> paketMap = (Map<String, Object>) request.get(Constants.PAKET04262564_KEY);
        
        try{
            StringBuffer str = new StringBuffer(paketMap.toString());
            
            String mappaket = str.toString();            System.out.println(mappaket);

            Paket04262564 paket = gson.fromJson(paketMap.toString(), Paket04262564.class);
            
            
            Integer jenisPengirimanId = paket.getJenisPengiriman().getId_kurir_service04262564();
            if(jenisPengirimanService.getById(jenisPengirimanId) == null){
                response.put(Constants.STATUS, "id_kurir_service not found");
                return response;
            }
            
            
            Integer pengirimId = paket.getPengirim().getNip_pengirim04262564();
            if(PengirimService.getById(pengirimId) == null){
                response.put(Constants.STATUS, "nip_pengirim not found");
                return response;
            }
            
            String trackPaketId = paket.getTrackPaket().getNomor_resi04262564();
            if(trackPaketService.getById(trackPaketId) == null){
                response.put(Constants.STATUS, "nomor_resi not found");
                return response;
            }
            
            
            paket.setOrder_id04262564(Integer.parseInt((String) paketMap.get("order_id04262564")));
            paket.setAlamat_paket04262564((String) paketMap.get("alamat_paket04262564"));
            paket.setPenerima04262564((String) paketMap.get("penerima04262564"));
            paket.setService04262564(((String) paketMap.get("service04262564")));
            paketService.insert(paket); 
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }

    
    @RequestMapping(value = "/master/paket04262564/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@RequestBody final Map<String, Object> request,
           @PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> paketMap = (Map<String, Object>) request.get(Constants.PAKET04262564_KEY);
        
        
        try{
            StringBuffer str = new StringBuffer(paketMap.toString());
            
            String mappaket = str.toString();            System.out.println(mappaket);

            Paket04262564 paket = gson.fromJson(paketMap.toString(), Paket04262564.class);
            
            
            
            Integer jenisPengirimanId = paket.getJenisPengiriman().getId_kurir_service04262564();
            if(jenisPengirimanService.getById(jenisPengirimanId) == null){
                response.put(Constants.STATUS, "id_kurir_service not found");
                return response;
            }
            
            
            Integer pengirimId = paket.getPengirim().getNip_pengirim04262564();
            if(PengirimService.getById(pengirimId) == null){
                response.put(Constants.STATUS, "nip_pengirim not found");
                return response;
            }
            
            String trackPaketId = paket.getTrackPaket().getNomor_resi04262564();
            if(trackPaketService.getById(trackPaketId) == null){
                response.put(Constants.STATUS, "nomor_resi not found");
                return response;
            }
            
            paket.setId_paket04262564(id);
            paket.setOrder_id04262564(Integer.parseInt((String) paketMap.get("order_id04262564")));
            paket.setAlamat_paket04262564((String) paketMap.get("alamat_paket04262564"));
            paket.setPenerima04262564((String) paketMap.get("penerima04262564"));
            paket.setService04262564(((String) paketMap.get("service04262564")));
            paketService.update(paket);
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    
    @RequestMapping(value = "/master/paket04262564/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Paket04262564 paket = new Paket04262564();
        
        try{
            paket.setId_paket04262564(id);
            
            paketService.delete(paket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
}
