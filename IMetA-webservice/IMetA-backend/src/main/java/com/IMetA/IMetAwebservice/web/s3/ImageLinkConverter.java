package com.IMetA.IMetAwebservice.web.s3;

import java.util.StringJoiner;

public class ImageLinkConverter {

    public String[] imageStringToList(String imageString) {

        return imageString.split(",");
    }

    public String imageListToString(String[] imageList) {

        StringJoiner sj = new StringJoiner(",");
        for (String image : imageList) {
            sj.add(image);
        }
        return sj.toString();
    }
}
