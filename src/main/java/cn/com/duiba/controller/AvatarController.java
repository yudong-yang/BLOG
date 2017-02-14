package cn.com.duiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AvatarController {

 /*   private Resource resource = new ClassPathResource("static/img/catty.jpeg");

    @RequestMapping(method = GET)
    @ResponseBody
    public byte[] avatar() throws IOException {
    	byte[] avat = Data.avatar;
    	if(avat!=null){
    		return avat;
    	}else{
    		return ByteStreams.toByteArray(resource.getInputStream());
    	}
//        return Data.avatar == null ? ByteStreams.toByteArray(resource.getInputStream()) : Data.avatar;
    }

    @RequestMapping(method = POST, value="/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        Data.avatar = file.getBytes();
        return "redirect:/upload";
    }*/
}