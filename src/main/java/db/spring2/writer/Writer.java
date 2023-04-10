package db.spring2.writer;

import db.spring2.calculator.Calculator;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Writer {

    public static String writeFile(List<Calculator> calculatorList) throws IOException {
        File file = new File("save_data");
        if (!file.exists()) {
            file.mkdir();
        }

        for (int index = 0; index < calculatorList.size(); index++) {
            calculatorList.get(index).serialize(String.valueOf(index), calculatorList.get(index));
        }
        return file.getName();
    }
}
