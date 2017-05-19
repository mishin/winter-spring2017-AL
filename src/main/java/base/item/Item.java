package base.item;

import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by Lauren on 4/6/2017.
 */

public class Item implements Serializable {

    @Id
    private Long id;
    private String word;

    public Item() {};

    public Item(String word) {
        this.word = word;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
