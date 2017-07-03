import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.FeatureDetector;


public class ImageRecognition {
    private float nndrRation = 0.7f;
    private int matchPointCount = 0;
    
    public void matchImage(Mat template, Mat origin) {
        MatOfKeyPoint templateKeyPoints = new MatOfKeyPoint();
        FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.SURF);
        featureDetector.detect(template, templateKeyPoints);
        MatOfKeyPoint templateDescriptors = new MatOfKeyPoint();
        
    }
    public float getNndrRation() {
        return nndrRation;
    }
    public void setNndrRation(float nndrRation) {
        this.nndrRation = nndrRation;
    }
    public int getMatchPointCount() {
        return matchPointCount;
    }
    public void setMatchPointCount(int matchPointCount) {
        this.matchPointCount = matchPointCount;
    }
}
