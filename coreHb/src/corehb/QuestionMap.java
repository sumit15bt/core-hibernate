/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corehb;

import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author avis
 */
@Entity
@Table
public class QuestionMap {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name, username;
    
    @ElementCollection(targetClass = String.class)
    private Map<String, String> answers;

    public QuestionMap() {
    }

    public QuestionMap(String name, String username, Map<String, String> answers) {
        super();
        this.name = name;
        this.username = username;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }

}
