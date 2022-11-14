/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsa.formKTM.formKTM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
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

    public String dataMahasiswa(
            @RequestParam("nNMaha") String form1,
            @RequestParam("nNIM") String form2,
            @RequestParam("nPs") String form3,
            @RequestParam("nEmail") String form4,
            @RequestParam("nTanggalL") @DateTimeFormat(pattern="yyyy-MM-dd") Date form5,
            @RequestParam("nFotoMaha") MultipartFile form6,
            Model paket
            
    )throws IOException{
        SimpleDateFormat newTgl = new SimpleDateFormat("dd MMMM yyyy");
        String tanggalL = newTgl.format(form5);
        
        String blob = Base64.encodeBase64String(form6.getBytes());
        String tampilgambar = "data:image/*;base64,"+blob;
        
        //Proses mengirim data 
        paket.addAttribute("pNMaha", form1);
        paket.addAttribute("pNIM", form2);
        paket.addAttribute("pPS", form3);
        paket.addAttribute("pEmail", form4);
        paket.addAttribute("pTanggalL", tanggalL);
        paket.addAttribute("pFotoMaha", tampilgambar);
        
        return "view";
    }
    
}
