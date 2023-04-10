package db.spring2.calculatorControler;

import db.spring2.calculator.Calculator;
import db.spring2.readData.ReadData;
import db.spring2.writer.Writer;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class CalculatorController {

    @PostMapping("/do-math")
    public String getParam(@RequestBody List<Calculator> calculators) throws IOException, InterruptedException {
        File file = new File("save_data");
        if (file.exists()) {
            file.delete();
        }
        for (Calculator calculator: calculators) {
            calculator.calculateResult();
            Thread.sleep(1000);
        }
        return Writer.writeFile(calculators);
    }

    @GetMapping("/check-finished/{filename}")
    public String checkFinished(@PathVariable(value = "filename")  String filename) {
        File file = new File(filename);
        if (file.exists()) {
            return "READY";
        } else {
            return null;
        }
    }

    @GetMapping("/result/{filename}")
    public ModelAndView result(@PathVariable(value ="filename") String filename) throws IOException, ParseException {
        ModelAndView modelAndView = new ModelAndView("result.html");
        modelAndView.addObject("calculators", ReadData.readList(filename));
        return modelAndView;
    }
}
