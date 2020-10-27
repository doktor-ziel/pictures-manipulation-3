package pl.backlog.green;

import org.opencv.core.Mat;

import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;
import static org.opencv.core.Core.addWeighted;
import static org.opencv.imgcodecs.Imgcodecs.*;
import static org.opencv.imgproc.Imgproc.*;

public class PutWatermarkOnImage {
    public static void main(String[] args) {
        nu.pattern.OpenCV.loadLocally();

        Mat image = imread("src/main/resources/inputImage.jpg", IMREAD_COLOR);
        cvtColor(image, image, COLOR_BGR2BGRA);

        Mat watermark = imread("src/main/resources/watermark.png", IMREAD_UNCHANGED);
        resize(watermark, watermark, image.size());

        Mat result = new Mat();
        addWeighted(image, 1, watermark, 1, 0, result);
        imwrite("src/main/resources/finalImage.png", result);
    }
}
