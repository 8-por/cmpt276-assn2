package cmpt276.asn2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cmpt276.asn2.models.rectangle;
import cmpt276.asn2.service.rectangleService;



@Controller
public class rectangleController {
    
    @Autowired
    private rectangleService rectangleService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listRectangles", rectangleService.getAllRectangles());
        return "RectangleIndex";
    }
    
    @GetMapping("/rectangle/{id}")
    public String getRectangleDetails(@PathVariable(value = "id") Long id, Model model) {
        Optional<rectangle> rectangle = rectangleService.getRectangle(id);
        if (rectangle.isPresent()) {
            model.addAttribute("rectangle", rectangle.get());
            return "RectangleDetails";
        } else {
            return "redirect:/";
        }
    }
    
    @GetMapping("/rectangle/new")
    public String createRectangle(Model model) {
        model.addAttribute("rectangle", new rectangle());
        return "RectangleEdit";
    }

    @PostMapping("/rectangle")
    public String saveRectangle(@ModelAttribute rectangle rectangle) {
        rectangleService.updateRectangle(rectangle);
        return "redirect:/";
    }

    @GetMapping("/rectangle/edit/{id}")
    public String editRectangle(@PathVariable(value = "id") Long id, Model model) {
        Optional<rectangle> rectangle = rectangleService.getRectangle(id);
        if (rectangle.isPresent()) {
            model.addAttribute("rectangle", rectangle.get());
            return "RectangleEdit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping(value = "/rectangle/update/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateRectangle(@PathVariable Long id, @ModelAttribute rectangle rectangleForm) {
        rectangle rectangle = rectangleService.getRectangle(id).orElseThrow(() -> new IllegalArgumentException("Invalid rectangle Id:" + id));
        rectangle.setName(rectangleForm.getName());
        rectangle.setWidth(rectangleForm.getWidth());
        rectangle.setHeight(rectangleForm.getHeight());
        rectangle.setColor(rectangleForm.getColor());
        rectangleService.updateRectangle(rectangle);
        return "redirect:/rectangle/" + id;
    }

    @GetMapping("/rectangle/delete/{id}")
    public String deleteRectangle(@PathVariable(value = "id") Long id) {
        rectangleService.deleteRectangle(id);
        return "redirect:/";
    }
}