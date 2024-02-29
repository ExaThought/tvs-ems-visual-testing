package com.tvsAccelerator.genric;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


public class takeScreenShot {
	public void takeScreenshot(String filename , WebDriver driver) throws IOException {
	Screenshot screenshot = new AShot().takeScreenshot(driver);
    ImageIO.write(screenshot.getImage(), "PNG", new File("./screenshot/baseLine/"+filename+".png"));
	}
}