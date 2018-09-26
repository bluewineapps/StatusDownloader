package com.bluewine.statusdownloader.utill;

public class HelpperMethods {

    public static boolean isImage(String file) {
        return ((file.endsWith(".jpg") || file.endsWith(".jpeg") || file.endsWith(".gif")))?true:false;

    }

    public static boolean isVideo(String file) {

        return ((file.endsWith(".mp4") || file.endsWith(".avi") || file.endsWith(".mkv")))?true:false;

    }

}
