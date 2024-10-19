package edu.du.sb1015_2.controller;

import edu.du.sb1015_2.entity.MyData;
import edu.du.sb1015_2.repository.MyDataRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MyController {

      final MyDataRepository myDataRepository;
//    public MyController(MyDataRepository myDataRepository) {
//        this.myDataRepository = myDataRepository;
//    }
        @GetMapping(value="/")
        public String index(@ModelAttribute("formModel") MyData myData, Model model) {
//            model.addAttribute("msg", "this is a sample content.");
            List<MyData> list = myDataRepository.findAll();
            model.addAttribute("datalist", list);
            return "index";
        }

        @PostMapping("/")
        public String form(@ModelAttribute("formModel") MyData myData) {
            myDataRepository.save(myData);
            return "redirect:/";
        }

        @GetMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model model) {
            Optional<MyData> myData1 = myDataRepository.findById(id);
            model.addAttribute("formModel", myData1.get());
            return "edit";
        }

        @PostMapping("/edit")
        public String update(@ModelAttribute MyData myData) {
            myDataRepository.save(myData);
            return "redirect:/";
          }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable("id") Long id,Model model) {
            Optional<MyData> myData1 = myDataRepository.findById(id);
            model.addAttribute("formModel", myData1.get());
            return "delete";
        }

        @GetMapping("/delete")
        public String delete(@ModelAttribute MyData myData) {
            myDataRepository.delete(myData);
            return "redirect:/";
        }

}
