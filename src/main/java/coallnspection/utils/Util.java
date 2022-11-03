package coallnspection.utils;

import coallnspection.Detect.EasyDl;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hyb
 * @school Xust
 * @data 2022/10/21
 */


public class Util {

    //存储最新的输出流
    //ByteArrayOutputStream不需要关闭，直接面向内存，用字节数组进行读写操作
//    static OutputStream outputStream1;

    /**
     *
     * @param bi 图像缓冲
     * @param outputStream 输出流对象
     * @throws IOException
     * @function 将图片转化为字节流输入到输出流
     */
    public static void readFileByBytes(BufferedImage bi, OutputStream outputStream) throws IOException {

//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileUrl));
//        byte[] bytes = new byte[1024];
//
//        while(bufferedInputStream.read(bytes) != -1) {
//            outputStream.write(bytes, 0, bytes.length);
//        }

//        outputStream1 = outputStream;
        //将bufferedImage直接转化为OutputStream
        ImageIO.write(bi,"png",outputStream);

    }

//    /**
//     * @function 将刚检测完的输出流对象还原
//     * @throws IOException
//     */
//    public static void refresh() throws IOException {
//        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) outputStream1;
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//
//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\projectTest\\Jdbc\\src\\img\\039.jpg");
//
//        fileOutputStream.write(bytes);
//        fileOutputStream.close();
//        outputStream1.close();
//    }

    /**
     * 获取当前时间的时间戳对象
     * @return
     */

    public static Timestamp getCurrentTime(int ts){
        Date date = new Date();
        date.setTime(ts);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return new Timestamp(date.getTime());
    }

    /**
     * 将获取的字节流转化为视频
     * @param mp4SavePath 转化后的视频存储路径
     * @param width 转化的视频的宽度
     * @param height 转化的视频的长度
     * @throws FFmpegFrameRecorder.Exception
     */

//    public static void pic2MovByFfmpeg(String mp4SavePath,int width, int height) throws FFmpegFrameRecorder.Exception {
//        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(mp4SavePath, width, height);
//        //设置视频编码层模式
//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//        //设置声音大小
//        recorder.setAudioChannels(2);
//        //设置视频为1帧每秒
//        recorder.setFrameRate(10);
//        //设置视频图像数据格式
//        recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//        recorder.setFormat("mp4");
//
//        try {
//            recorder.start();
//            Java2DFrameConverter converter = new Java2DFrameConverter();
//            int len = EasyDl.list.size();
//            //循环读取数据
//            for(int i = 0; i < len; i++){
//                //将字节数组进行转化
//                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(EasyDl.list.get(i));
//                BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
//                recorder.record(converter.getFrame(bufferedImage));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //最后一定要结束并释放资源
//            recorder.stop();
//            recorder.release();
//        }
//    }


    /**
     * 将Image对象转化为bufferedImage对象
     * @param image
     * @return
     */
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
        }

        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Determine if the image has transparent pixels; for this method's
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        //boolean hasAlpha = hasAlpha(image);

        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
	       /* if (hasAlpha) {
	         transparency = Transparency.BITMASK;
	         }*/

            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(
                    image.getWidth(null), image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }

        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            //int type = BufferedImage.TYPE_3BYTE_BGR;//by wang
	        /*if (hasAlpha) {
	         type = BufferedImage.TYPE_INT_ARGB;
	         }*/
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }

        // Copy image to buffered image
        Graphics g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }



}
