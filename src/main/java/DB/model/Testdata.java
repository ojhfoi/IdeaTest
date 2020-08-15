package DB.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "testdata")
public class Testdata implements Serializable {
    private int id;
    private String url;
    private String tag;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 100)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "tag", nullable = false, length = 100)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Testdata testdata = (Testdata) o;

        if (id != testdata.id) return false;
        if (url != null ? !url.equals(testdata.url) : testdata.url != null) return false;
        if (tag != null ? !tag.equals(testdata.tag) : testdata.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
