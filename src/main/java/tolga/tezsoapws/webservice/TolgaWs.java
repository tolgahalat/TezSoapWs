/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tolga.tezsoapws.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import tolga.tezsoapws.entity.Mukellef;
import tolga.tezsoapws.util.TezUtil;

/**
 *
 * @author Tolga
 */
@WebService(serviceName = "TolgaWs")
public class TolgaWs {
    
    @WebMethod(operationName = "Test")
    public String test() {
        return "test";
    }
    
    @WebMethod(operationName = "getById")
    public Mukellef getById(@WebParam(name = "id") String id) {
        return TezUtil.getById(id);
    }
}
