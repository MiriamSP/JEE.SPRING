package restApi;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restApi.exceptions.DivisionZeroException;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.BASICS)
public class BasicResource {

    @RequestMapping(value = Uris.STATE, method = RequestMethod.GET)
    public String start() {
        return "{\"response\":\"OK " + Uris.VERSION + "\"}";
    }
    
    @RequestMapping(value = Uris.CALC, method = RequestMethod.GET)
    public String divide(@RequestParam int dividendo, @RequestParam int divisor) throws DivisionZeroException {
        if (divisor == 0){
            throw new DivisionZeroException();
        }
                
        String resultado = "division:" + dividendo / divisor;
        return resultado;
    }
    
     
    

}
