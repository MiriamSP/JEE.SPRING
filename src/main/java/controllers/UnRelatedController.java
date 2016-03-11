package controllers;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import daos.UnRelatedDao;
import entities.Gender;
import entities.UnRelatedEntity;

@Controller
public class UnRelatedController {

    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        String[] list = {"0", "1", "2", "3", "4"};
        UnRelatedEntity entity = new UnRelatedEntity("Mi Nick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        unRelatedDao.save(entity);
        UnRelatedEntity entity2 = new UnRelatedEntity("Miriam", Gender.FEMALE, new GregorianCalendar(1984, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        unRelatedDao.save(entity2);
        System.out.println(">>>> UnRelatedEntity:  " + unRelatedDao.findOne(entity.getId()));
        
        
        String nick = "Miriam";
        System.out.println(">>>> Query: findNickByNickLike:" + unRelatedDao.findNickByNickLike(nick));  
        System.out.println(">>>> Query: findIdByIdBetween:" + unRelatedDao.findIdByIdBetween(0,3));  
               
        System.out.println(">>>> Query: findByNickAge:" + unRelatedDao.findByNickAge(nick));  
        //Consultas de paginación
        Pageable pageable = new PageRequest(1, 5);
        System.out.println(">>>> Query Paginación: findByIdGreaterThan:" + unRelatedDao.findByIdGreaterThan(1,pageable)); 
        System.out.println(">>>> Query - count (numero registros dao): findByIdGreaterThan:" + unRelatedDao.count()); 
        
        List<UnRelatedEntity> list1 =  unRelatedDao.findByIdGreaterThan(1,pageable);
        // recorrrer bucle y mostrar resultado..
        

       
        
    }
}
