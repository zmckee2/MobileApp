/**
 * This program contains the state and behavior for a note object
 * CPSC 312-02, Fall 2019
 * Programming Assignment #6
 * No sources to cite
 *
 * @author Zach McKee
 * @version v1.0 11/6/19
 */
package mckee.zach.PA7;

public class Note {
    private String title;
    private String content;
    private String type;

    public Note(String title, String content, String type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString()
    {
        return title;
    }
}
