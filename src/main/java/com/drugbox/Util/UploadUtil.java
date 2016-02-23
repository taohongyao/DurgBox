package com.drugbox.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 44247 on 2016/2/23 0023.
 */
public class UploadUtil {
    public static boolean isImageByName(String fileName){
        String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        return isImage(ext);
    }
    public static boolean isImage(String type){
        List<String> fileTypes = new ArrayList<String>();
        fileTypes.add("jpg");
        fileTypes.add("jpeg");
        fileTypes.add("bmp");
        fileTypes.add("gif");
        return fileTypes.contains(type);
    }
}
