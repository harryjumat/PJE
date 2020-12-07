/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.controller;

import com.je.spring.rest.model.TrackPaket04262564;
import com.je.spring.rest.service.TrackPaketService04262564;
import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Bib_
 */
@Controller
public class TrackPaketController04262564 {
    
    @Autowired
    private TrackPaketService04262564 trackPaketService;
    
    @RequestMapping(value = "/master/track-paket04262564", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<TrackPaket04262564> trackPaketList = trackPaketService.getAll();
            long count = trackPaketService.count();
            
            response.put(Constants.LIST, trackPaketList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/track-paket04262564/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final String id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            TrackPaket04262564 trackPaket = trackPaketService.getById(id);
            response.put(Constants.TRACKPAKET04262564_KEY, trackPaket);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/track-paket04262564", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> trackPaketMap = (Map<String, Object>) request.get(Constants.TRACKPAKET04262564_KEY);
        TrackPaket04262564 trackPaket = new TrackPaket04262564();
        
        try{
            
            trackPaket.setNomor_resi04262564((String) trackPaketMap.get("nomor_resi04262564"));
            trackPaket.setKode_cabang04262564(Integer.parseInt((String)trackPaketMap.get("kode_cabang04262564")));
            trackPaket.setNip_pengirim04262564(Integer.parseInt((String)trackPaketMap.get("nip_pengirim04262564")));
            trackPaket.setKeterangan04262564((String) trackPaketMap.get("keterangan04262564"));
            trackPaket.setLokasi04262564((String) trackPaketMap.get("lokasi04262564"));
                    
            trackPaketService.insert(trackPaket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/track-paket04262564/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final String id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> trackPaketMap = (Map<String, Object>) request.get(Constants.TRACKPAKET04262564_KEY);
        TrackPaket04262564 trackPaket = new TrackPaket04262564();
        
        try{
            trackPaket.setNomor_resi04262564(id);
            trackPaket.setKode_cabang04262564(Integer.parseInt((String)trackPaketMap.get("kode_cabang04262564")));
            trackPaket.setNip_pengirim04262564(Integer.parseInt((String)trackPaketMap.get("nip_pengirim04262564")));
            trackPaket.setKeterangan04262564((String) trackPaketMap.get("keterangan04262564"));
            trackPaket.setLokasi04262564((String) trackPaketMap.get("lokasi04262564"));
            trackPaketService.update(trackPaket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/track-paket04262564/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final String id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        TrackPaket04262564 trackPaket = new TrackPaket04262564();
        
        try{
            trackPaket.setNomor_resi04262564(id);
            
            trackPaketService.delete(trackPaket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
}
