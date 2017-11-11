package edm.music.t3v.model;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class BlogRadio {
    public String id_radio, name_radio, thumb_radio, category_radio, file_radio, view_radio, comment_radio, like_radio;
    public BlogRadio(){}
    public BlogRadio(String id_radio, String name_radio, String thumb_radio, String category_radio, String file_radio, String view_radio, String comment_radio, String like_radio){
        this.name_radio = name_radio;
        this.thumb_radio = thumb_radio;
        this.id_radio = id_radio;
        this.category_radio = category_radio;
        this.file_radio = file_radio;
        this.view_radio = view_radio;
        this.comment_radio = comment_radio;
        this.like_radio = like_radio;
    }

    public String getId_radio() {
        return id_radio;
    }

    public void setId_radio(String id_radio) {
        this.id_radio = id_radio;
    }

    public String getName_radio() {
        return name_radio;
    }

    public void setName_radio(String name_radio) {
        this.name_radio = name_radio;
    }

    public String getThumb_radio() {
        return thumb_radio;
    }

    public void setThumb_radio(String thumb_radio) {
        this.thumb_radio = thumb_radio;
    }

    public String getCategory_radio() {
        return category_radio;
    }

    public void setCategory_radio(String category_radio) {
        this.category_radio = category_radio;
    }

    public String getFile_radio() {
        return file_radio;
    }

    public void setFile_radio(String file_radio) {
        this.file_radio = file_radio;
    }

    public String getView_radio() {
        return view_radio;
    }

    public void setView_radio(String view_radio) {
        this.view_radio = view_radio;
    }

    public String getComment_radio() {
        return comment_radio;
    }

    public void setComment_radio(String comment_radio) {
        this.comment_radio = comment_radio;
    }

    public String getLike_radio() {
        return like_radio;
    }

    public void setLike_radio(String like_radio) {
        this.like_radio = like_radio;
    }
}
