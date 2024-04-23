package com.pchailam.ex10_viewpaper2_slide;

public class Landscape {
    private String landScapeName;
    private String landScapeImage;

    public Landscape(String landScapeName, String landScapeImage) {
        this.landScapeName = landScapeName;
        this.landScapeImage = landScapeImage;
    }

    public String getLandScapeName() {
        return landScapeName;
    }

    public void setLandScapeName(String landScapeName) {
        this.landScapeName = landScapeName;
    }

    public String getLandScapeImage() {
        return landScapeImage;
    }

    public void setLandScapeImage(String landScapeImage) {
        this.landScapeImage = landScapeImage;
    }
}