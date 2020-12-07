/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
1711502664 - Habiburrahman Ahmadi
*/

package com.je.spring.rest.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.model.JenisPengiriman04262564;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.service.JenisPengirimanService04262564;
/**
 *
 * @author Bib_
 */
@Controller
public class JenisPengirimanController04262564 
{
    @Autowired
    private JenisPengirimanService04262564 jenisPengirimanService;
    
    @RequestMapping(value = "/master/jenis-pengiriman04262564", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<JenisPengiriman04262564> jenisPengirimanList = jenisPengirimanService.getAll();
            long count = jenisPengirimanService.count();
            
            response.put(Constants.LIST, jenisPengirimanList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman04262564/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            JenisPengiriman04262564 jenisPengiriman = jenisPengirimanService.getById(id);
            response.put(Constants.JENISPENGIRIMAN04262564_KEY, jenisPengiriman);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman04262564", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> jenisPengirimanMap = (Map<String, Object>) request.get(Constants.JENISPENGIRIMAN04262564_KEY);
        JenisPengiriman04262564 jenisPengiriman = new JenisPengiriman04262564();
        
        try{
            jenisPengiriman.setId_kurir_service04262564(Integer.parseInt((String) jenisPengirimanMap.get("id_kurir_service04262564")));
            jenisPengiriman.setNama_service04262564((String) jenisPengirimanMap.get("nama_service04262564"));

            jenisPengiriman.setId_harga_service04262564(Integer.parseInt((String)jenisPengirimanMap.get("harga_service04262564")));
            jenisPengiriman.setLama_hari04262564(Integer.parseInt((String)jenisPengirimanMap.get("lama_hari04262564")));
            jenisPengiriman.setBerat_barang04262564((String) jenisPengirimanMap.get("berat_barang04262564"));
                    
            jenisPengirimanService.insert(jenisPengiriman);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman04262564/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> jenisPengirimanMap = (Map<String, Object>) request.get(Constants.JENISPENGIRIMAN04262564_KEY);
        JenisPengiriman04262564 jenisPengiriman = new JenisPengiriman04262564();
        
        try{
            jenisPengiriman.setId_kurir_service04262564(id);
            jenisPengiriman.setNama_service04262564((String) jenisPengirimanMap.get("nama_service04262564"));
            jenisPengiriman.setId_harga_service04262564(Integer.parseInt((String)jenisPengirimanMap.get("harga_service04262564")));
            jenisPengiriman.setLama_hari04262564(Integer.parseInt((String)jenisPengirimanMap.get("lama_hari04262564")));
            jenisPengiriman.setBerat_barang04262564((String) jenisPengirimanMap.get("berat_barang04262564"));
            jenisPengirimanService.update(jenisPengiriman);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman04262564/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        JenisPengiriman04262564 jenisPengiriman = new JenisPengiriman04262564();
        
        try{
            jenisPengiriman.setId_kurir_service04262564(id);
            
            jenisPengirimanService.delete(jenisPengiriman);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
}
