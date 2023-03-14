package com.example.OB1.Service;

import com.example.OB1.Models.bootCamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class bootCamperService {

    private List<bootCamper> bootCamperList= new ArrayList();


    public bootCamper findById(Long id){

        for (bootCamper aux: bootCamperList) {
            if(aux.getId()==id) return aux;
        }
        return null;
    }
    public List<bootCamper> getAll() {
        return bootCamperList;
    }

    public void add(bootCamper bootCamper){
        bootCamperList.add(bootCamper);
    }
}
