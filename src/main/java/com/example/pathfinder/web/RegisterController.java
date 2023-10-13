package com.example.pathfinder.web;

import com.example.pathfinder.model.entity.dto.UserRegisterDto;
import com.example.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegisterModel")
    public UserRegisterDto userRegisterDto() {
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterModel",userRegisterDto);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "userRegisterModel", bindingResult);
            return "redirect:/user/register";
        }

        userService.doRegister(userRegisterDto);
        System.out.println(userRegisterDto);
        return "redirect:/";
    }
}
