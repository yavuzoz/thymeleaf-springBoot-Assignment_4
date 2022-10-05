package ch.bfh.ti.simple_springboot_thymeleaf_example_1.entity;
public class AboutUs {
    private String title;
    private String text;
    public AboutUs(String title, String text) {
        this.title = title;
        this.text = text;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
