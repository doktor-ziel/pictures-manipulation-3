package pl.backlog.green;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ScaleInputImage {
    public static void main(String[] args) {
        nu.pattern.OpenCV.loadLocally();

        Mat inputImage = Imgcodecs.imread("src/main/resources/inputImage.jpg");
        Size inSize = inputImage.size();

        Mat outputImage = new Mat();
        Size outSize = new Size(inSize.width/3, inSize.height/3);

        Imgproc.resize(inputImage, outputImage, outSize);
        Imgcodecs.imwrite("src/main/resources/outputImage.jpg", outputImage);
    }
}
