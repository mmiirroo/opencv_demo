import java.util.StringTokenizer;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class Test {
    public static void main(String[] args) {
        String property = System.getProperty("java.library.path");
        StringTokenizer parser = new StringTokenizer(property, ";");
        while (parser.hasMoreTokens()) {
            System.err.println(parser.nextToken());
            }
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat source, template;
        source = Imgcodecs.imread("D:\\workspace\\my\\TemplateMatch\\pic\\srceenshot.png");
        template = Imgcodecs.imread("D:\\workspace\\my\\TemplateMatch\\pic\\cctv1.png");;
        
        Mat result = Mat.zeros(source.rows()- template.rows() + 1, source.cols()-template.cols()+1, CvType.CV_32FC1);
        Imgproc.matchTemplate(source, template, result, Imgproc.TM_SQDIFF_NORMED);
        
        Core.MinMaxLocResult mlr = Core.minMaxLoc(result);
        Point matchLoc = mlr.minLoc;
        Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.width(), matchLoc.y + template.height()), new Scalar(0, 255, 0));
        Imgcodecs.imwrite("D:\\workspace\\my\\TemplateMatch\\pic\\matched.png", source);
    }
}
