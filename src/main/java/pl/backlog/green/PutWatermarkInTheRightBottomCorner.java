package pl.backlog.green;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

import static org.opencv.core.Core.addWeighted;
import static org.opencv.imgcodecs.Imgcodecs.*;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2BGRA;
import static org.opencv.imgproc.Imgproc.cvtColor;

public class PutWatermarkInTheRightBottomCorner {
    public static void main(String[] args) {
        nu.pattern.OpenCV.loadLocally();

        Mat image = imread("src/main/resources/inputImage.jpg", IMREAD_COLOR);
        cvtColor(image, image, COLOR_BGR2BGRA);

        Mat watermark = imread("src/main/resources/watermark.png", IMREAD_UNCHANGED);
        Mat transparentLayer = new Mat(image.rows(), image.cols(), CvType.CV_8UC4);
        Rect roi = new Rect(
                image.cols() - watermark.cols(),
                image.rows() - watermark.rows(),
                watermark.cols(),
                watermark.rows());
        watermark.copyTo(transparentLayer.submat(roi));

        Mat result = new Mat();
        addWeighted(image, 1, transparentLayer, 1, 0, result);
        imwrite("src/main/resources/finalImage.png", result);
    }
}
