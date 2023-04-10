package db.spring2.calculator;

import java.io.*;

public class Calculator implements Serializable{
    double[] variables;
    String operator;
    double result;

    public Calculator() {

    }

    public Calculator(double[] variables, String operator) {
        this.variables = variables;
        this.operator = operator;
    }

    public void calculateResult() {
        if (operator.equals("sum")) {
            this.result = variables[0] + variables[1];
        } else if (operator.equals("dif")) {
            this.result = variables[0] - variables[1];
        } else if (operator.equals("pow")) {
            this.result = Math.pow(variables[0], variables[1]);
        } else if (operator.equals("div")) {
            this.result = variables[0] / variables[1];
        }
    }
    public void serialize(String filename, Calculator calculator) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("save_data/" + filename));
            outputStream.writeObject(calculator);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public double[] getVariables() {
        return variables;
    }

    public void setVariables(double[] variables) {
        this.variables = variables;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
