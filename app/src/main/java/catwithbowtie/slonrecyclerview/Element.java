package catwithbowtie.slonrecyclerview;

public class Element {
    private int id;
    private String content;

    public Element(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Element() { }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
