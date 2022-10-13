package coallnspection.pojo;

/**
 * 用于表示解析后返回的值
 */

public class Analysis {

    private String type;
    private int length;
    private int width;
    private int left;
    private int top;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public Analysis(String type, int length, int width, int left, int top) {
        this.type = type;
        this.length = length;
        this.width = width;
        this.left = left;
        this.top = top;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "type='" + type + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
