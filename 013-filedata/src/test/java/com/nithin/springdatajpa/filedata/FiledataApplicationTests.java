package com.nithin.springdatajpa.filedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nithin.springdatajpa.filedata.entities.Image;
import com.nithin.springdatajpa.filedata.repo.ImageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FiledataApplicationTests {

	@Autowired
	ImageRepository ir;
	
	@Test
	public void testImageSave() throws IOException {
		Image image = new Image();
		
		image.setId(1);
		image.setName("certi.png");
		
		File file = new File("C:\\Users\\Nithin\\Desktop\\Documents\\certi.png");
		byte[] imageContent = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(imageContent);
		
		image.setData(imageContent);
		ir.save(image);
		fis.close();
	}
	
	@Test
	public void testReadImage() {
		Image image = ir.findById(1L).get();
		File file = new File("C:\\Users\\Nithin\\Desktop\\Documents\\downloaded\\"+image.getName());
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			fos.write(image.getData());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}