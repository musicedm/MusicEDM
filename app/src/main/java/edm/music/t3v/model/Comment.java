package edm.music.t3v.model;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class Comment {
    public String id,name,comment,time;

    public Comment() {
    }

    public Comment(String id, String name, String comment, String time) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
