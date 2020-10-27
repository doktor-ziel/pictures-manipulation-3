package pl.backlog.green;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class CreateWatermark {
    public static void main(String[] args) {
        nu.pattern.OpenCV.loadLocally();

        Mat image = new Mat(200, 200, CvType.CV_8UC4, new Scalar(0,0,0,0));

        String text = "Doktor Ziel";
        Point position = new Point(10, 110);
        Scalar color = new Scalar(90, 60, 90, 255);
        int font = Imgproc.FONT_HERSHEY_SIMPLEX;
        int scale = 1;
        int thickness = 4;
        Imgproc.putText(image,text, position, font, scale, color, thickness);

        Imgcodecs.imwrite("src/main/resources/watermark.png", image);
    }
}
