/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsa.formKTM.formKTM;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author ASUS
 */
@Controller
public class thisController {
    @RequestMapping("/displaydata")
    @ResponseBody
    
    public String dataMahasiswa(
            @RequestParam("nMaha") String form1,
            @RequestParam("nNIM") String form2,
            @RequestParam("nPS") String form3,
            @RequestParam("nFotoMaha") MultipartFile form4,
            Model paket
    )throws IOException{
        String blob = Base64.encodeBase64String(form4.getBytes());
        
        paket.addAttribute("pMaha", form1);
        paket.addAttribute("pNIM", form2);
        paket.addAttribute("pPS", form3);
        
        return "view"+"<center><br/><br/><img src='data:image/*;base64,"+blob+"' /><br/><br/><center/>";
    }
    
}
