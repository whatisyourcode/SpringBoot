package edu.du.sb1022secuFinal.controller;

import edu.du.sb1022secuFinal.entity.Member;
import edu.du.sb1022secuFinal.repository.MemberRepository;
import edu.du.sb1022secuFinal.spring.DuplicateMemberException;
import edu.du.sb1022secuFinal.spring.MemberRegisterService;
import edu.du.sb1022secuFinal.spring.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;


@Controller
public class RegisterController {

	@Autowired
	private MemberRegisterService memberRegisterService;

	@Autowired
	private MemberRepository memberRepository;


	private PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

	@PostConstruct
	public void init() {
		Member member = Member.builder()
				.id(1001L)
				.name("hong1")
				.password(passwordEncoder().encode("1234"))
				.email("hong@aaa.com")
				.build();
		Member admin = Member.builder()
				.id(1000L)
				.name("admin")
				.password(passwordEncoder().encode("1234"))
				.email("admin@aaa.com")
				.build();
		memberRepository.save(admin);
		memberRepository.save(member);
	}

	
	@GetMapping("/")
	public String root() {
		return "/register/step1";
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/register/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			return "register/step2";
		}
	}

}
