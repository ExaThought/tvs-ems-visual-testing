package com.utils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ComparisionUtility {
	
	/*public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest logger;*/
	
	
	@Test
	
	public static void CompareImages() throws IOException
	{
		/*extent = new ExtentReports();
		spark = new ExtentSparkReporter("./Report/OutputReport.html");
		extent.attachReporter(spark);*/
		
		
		// Set the path to your ExpectedImages and ActualImages folders
        String expectedFolderPath = "."+File.separator+ "ExpectedResult"+File.separator+"ExpectedImages";
        String actualFolderPath = "."+File.separator+ "ActualResult"+File.separator+ "ActualImages";

        // Set the path to the folder where you want to save the comparison output
        String outputFolderPath = "."+File.separator+ "Output"+File.separator+ "ComparisionOutput";

        // Get all files from the ExpectedImages folder
        File expectedFolder = new File(expectedFolderPath);
        File[] expectedFiles = expectedFolder.listFiles();

        if (expectedFiles != null) {
            // Iterate through each file in ExpectedImages folder
            for (File expectedFile : expectedFiles) {
                // Construct the corresponding file path in ActualImages folder
                String actualFilePath = actualFolderPath + File.separator + expectedFile.getName();

                // Check if the file with the same name exists in ActualImages folder
                File actualFile = new File(actualFilePath);
                if (actualFile.exists()) {
                    // Perform image comparison using AShot
                    compareImages(expectedFile, actualFile, outputFolderPath);
                } else {
                    System.out.println("File not found in ActualImages folder: " + expectedFile.getName());
                }
            }
        } else {
            System.out.println("No files found in ExpectedImages folder.");
        }
    }

    private static void compareImages(File expectedFile, File actualFile, String outputFolderPath) throws IOException {
        // Load images from files
        BufferedImage expectedImage = ImageIO.read(expectedFile);
        BufferedImage actualImage = ImageIO.read(actualFile);

        // Get the image differences using AShot
        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

        // Check if there are differences
        if (diff.hasDiff()) {
            System.out.println("Images are not identical: " + expectedFile.getName());
            // Save the diff image to the output folder
            File outputDiffFile = new File(outputFolderPath + File.separator + expectedFile.getName());
            ImageIO.write(diff.getMarkedImage(), "png", outputDiffFile);
            System.out.println("Diff image saved: " + outputDiffFile.getAbsolutePath());
        } else {
        	
        	File outputDiffFile = new File(outputFolderPath + File.separator + expectedFile.getName());
        	ImageIO.write(diff.getMarkedImage(), "png", outputDiffFile);
            System.out.println("Images are identical: " + expectedFile.getName());
        }
    }
}
