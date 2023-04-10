package db.spring2.readData;

import db.spring2.calculator.Calculator;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadData {
    public static Calculator deserialize(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("save_data/" + fileName))) {
            return (Calculator) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public static List<Calculator> readList(String filename) throws IOException, ParseException {
        List<Calculator> calculators = new ArrayList<>();
        File director = new File(filename);
        for (File file : Objects.requireNonNull(director.listFiles())) {
            if (!file.isDirectory()) {
                calculators.add(deserialize(file.getName()));
            }
        }
        return calculators;
    }
}
