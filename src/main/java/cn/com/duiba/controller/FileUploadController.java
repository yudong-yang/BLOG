package cn.com.duiba.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.File;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	
	 public static final String ROOT = "./src/mian/resources/static/images/";

		private final ResourceLoader resourceLoader;

		@Autowired
		public FileUploadController(ResourceLoader resourceLoader) {
			this.resourceLoader = resourceLoader;
		}
	  
		
		  @RequestMapping(value="/file" ,method = GET)
		    public String upload() {
		        return "file";
		    }
		
		  @RequestMapping(value="/file/{filename}" ,method = GET)
		    public String toupload(Model model,@PathVariable("filename") String name) {
			  model.addAttribute("name", name);
		        return "file";
		    }
		
		@RequestMapping(method = GET,value = "/avatar/{filename:.+}")
	    @ResponseBody
	    public ResponseEntity<?> getFile(@PathVariable String filename) {
	        try {
	        	System.out.println("=============================获取图片============================");
	            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	
		@RequestMapping(value ="/avatar", method = RequestMethod.POST )
		    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
			String filename = file.getOriginalFilename();
			String filepath = Paths.get(ROOT, filename).toString();
			 try {
				    // Get the filename and build the local file path (be sure that the 
				    // application have write permissions on such directory)
//				    String directory = "./src/mian/resources/static/images/";
				    
				    // Save the file locally
				   /* BufferedOutputStream stream =
				        new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				    stream.write(uploadfile.getBytes());
				    stream.close();*/
				    FileUtils.writeByteArrayToFile(new File(filepath), file.getBytes());
				  }
				  catch (Exception e) {
				    System.out.println(e.getMessage());
				   
				  }
				  
				  return "redirect:file/"+filename;
				} 
		    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*	// 访问路径为：http://127.0.0.1:7171/file
	@RequestMapping("/file")
	public String file() {
		return "/file";
	}

	*//**
	 * 文件上传具体实现方法;
	 * 
	 * @param file
	 * @return
	 *//*
	@RequestMapping("/upload")
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {

			try {
				
				 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
				 * d:/files大家是否能实现呢？ 等等;
				 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
				 * 3、文件格式; 4、文件大小的限制;
				 
				// 获取文件名
				String fileName = file.getOriginalFilename();
				System.out.println("上传的文件名为：" + fileName);

				String path = "./src/mian/resources/static/img/";

				File uploadfile = new File(path + fileName);

				// 检测是否存在该文件
				if (!uploadfile.exists()) {
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(uploadfile));
					out.write(file.getBytes());
					out.flush();
					out.close();
					return "上传成功";
				} else {
					System.out.println("已存在上传的文件：" + fileName);
					return "文件已存在";
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "上传失败," + e.getMessage();
			} catch (IOException e) {
				e.printStackTrace();
				return "上传失败," + e.getMessage();
			}

		} else {
			return "上传失败，因为文件是空的.";
		}
	}*/
}
