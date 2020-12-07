package com.je.spring.rest.controller;

import com.je.spring.rest.model.Pengirim04262564;
import com.je.spring.rest.service.PengirimService04262564;
import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PengirimController04262564 {
    
    @Autowired
    private PengirimService04262564 pengirimservice;
    
    @RequestMapping(value = "/master/pengirim04262564", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Pengirim04262564> PengirimList = pengirimservice.getAll();
            long count = pengirimservice.count();
            
            response.put(Constants.LIST, PengirimList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pengirim04262564/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Pengirim04262564 Pengirim = pengirimservice.getById(id);
            response.put(Constants.PENGIRIM04262564_KEY, Pengirim);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
     @RequestMapping(value = "/master/pengirim04262564", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> PengirimMap = (Map<String, Object>) request.get(Constants.PENGIRIM04262564_KEY);
        Pengirim04262564 Pengirim = new Pengirim04262564();
        
        try{
            Pengirim.setNip_pengirim04262564(Integer.parseInt((String) PengirimMap.get("nip_pengirim04262564")));
            Pengirim.setNama_pengirim04262564((String) PengirimMap.get("nama_pengirim04262564"));
            Pengirim.setTelp_pengirim04262564((String) PengirimMap.get("telp_pengirim04262564"));
            Pengirim.setEmail_pengirim04262564((String) PengirimMap.get("email_pengirim04262564"));
            Pengirim.setAlamat_pengirim04262564((String) PengirimMap.get("alamat_pengirim04262564"));
                    
            pengirimservice.insert(Pengirim);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pengirim04262564/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> PengirimMap = (Map<String, Object>) request.get(Constants.PENGIRIM04262564_KEY);
        Pengirim04262564 Pengirim = new Pengirim04262564();
        
        try{
            Pengirim.setNip_pengirim04262564(id);
            Pengirim.setNama_pengirim04262564((String) PengirimMap.get("nama_pengirim04262564"));
            Pengirim.setTelp_pengirim04262564((String) PengirimMap.get("telp_pengirim04262564"));
            Pengirim.setEmail_pengirim04262564((String) PengirimMap.get("email_pengirim04262564"));
            Pengirim.setAlamat_pengirim04262564((String) PengirimMap.get("alamat_pengirim04262564"));
            pengirimservice.update(Pengirim);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pengirim04262564/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Pengirim04262564 Pengirim = new Pengirim04262564();
        
        try{
            Pengirim.setNip_pengirim04262564(id);
            
            pengirimservice.delete(Pengirim);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
}