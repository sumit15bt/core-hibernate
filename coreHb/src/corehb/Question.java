/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corehb;

import java.io.Serializable;
import java.util.List;
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
public class Question implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String qname;
    
    @ElementCollection(targetClass=String.class)
    private List<String> answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
