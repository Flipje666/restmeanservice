package nl.hu.iac.service;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by Philip on 3/16/2017.
 */
@XmlRootElement
public class Mean {
    private double result;

    public Mean() {}

    public Mean(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
