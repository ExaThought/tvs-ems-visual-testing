package demoVTest.genric;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;


public class compareSS extends baseclass {
	public void compareScreenshot(String filename, WebDriver driver) throws IOException 
{
	BufferedImage expectedR = ImageIO.read(new File("./Screenshot/baseLine/"+filename+".png"));
    
    //compare it to the element on webpage 
    Screenshot filename1 = new AShot().takeScreenshot(driver);
    ImageIO.write(filename1.getImage(), "PNG", new File("./screenshot/comparision/"+filename+".png"));
	BufferedImage actualImage = filename1.getImage();
	ImageDiffer imageDiffer = new ImageDiffer();
	ImageDiff imageDiff = imageDiffer.makeDiff(expectedR, actualImage);
	
	// if any difference found then get the image with difference highlighted else say image is same 
	if(imageDiff.hasDiff()==true)
	{
	ImageIO.write(imageDiff.getMarkedImage(), "PNG", new File("./Screenshot/result/diff"+filename+"PG_Result.png"));
	//Assert.fail();
	}
	else 
	{
		ImageIO.write(imageDiff.getMarkedImage(), "PNG", new File("./Screenshot/result/Same"+filename+"_Result.png"));
		System.out.println("image is same");
	}
	
}}
